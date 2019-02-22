package com.me.ready.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @Autor syl
 * @Date 2019/2/22 17:35
 **/
public class NIOServer {

    // 通道管理器
    private Selector selector;

    public void initServer(int port) throws IOException {
        // 获得一个ServerSocket通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 设置通道为非阻塞
        serverSocketChannel.configureBlocking(false);
        // 讲该通道对应的ServerSocket绑定到port端口上
        serverSocketChannel.bind(new InetSocketAddress(port));
        // 获得一个通道管理器
        selector = Selector.open();
        // 将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_ACCEPT事件，注册该事件后
        // 当该事件到达后，selector.select()会返回，如果该事件没到达selector.select()会一直阻塞
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    // 采用轮询的方式监听selector上是否有需要处理的事件，如果有的话，则进行处理
    public void listen() throws IOException {
        System.out.println("服务端启动成功...");
        //  轮询访问selector
        while (true) {
            // 当注册事件到达时，方法返回，否则一直阻塞
            selector.select();
            // 获得selector中选中的迭代器，选中的项为注册的事件
            Iterator<SelectionKey> iterator = this.selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                // 删除已经选择的key，防止重复处理
                iterator.remove();
                handler(selectionKey);
            }
        }
    }

    // 处理请求
    public void handler(SelectionKey selectionKey) throws IOException {
        // 客户端请求连接
        if (selectionKey.isAcceptable()) {
            handlerAccept(selectionKey);
            // 获得可读事件
        } else if (selectionKey.isReadable()) {
            handlerRead(selectionKey);
        }
    }

    // 处理连接请求
    public void handlerAccept(SelectionKey selectionKey) throws IOException {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
        // 获得客户端连接的通道
        SocketChannel channel = serverSocketChannel.accept();
        // 设置为非阻塞
        channel.configureBlocking(false);
        // 这里可以发送消息给客户端
        System.out.println("新的客户端连接...." + selectionKey.toString());
        // 在和客户端连接成功后，为了可以给客户端发送消息，需要设置通道读的权限
        channel.register(this.selector, SelectionKey.OP_READ);
    }

    // 处理读请求
    public void handlerRead(SelectionKey selectionKey) throws IOException {
        SocketChannel channel = (SocketChannel) selectionKey.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int read = channel.read(buffer);
        if (read > 0) {
            byte[] data = buffer.array();
            System.out.println("服务器端接收到" + selectionKey.toString() + "的消息:" + new String(data));
            ByteBuffer outBuffer = ByteBuffer.wrap("服务器端收到你的消息了".getBytes("GBK"));
            channel.write(outBuffer);
        } else {
            System.out.println("客户端关闭:" + selectionKey.toString());
            selectionKey.cancel();
        }
    }

    public static void main(String[] args) throws IOException {
        NIOServer nioServer = new NIOServer();
        nioServer.initServer(8000);
        nioServer.listen();
    }
}
