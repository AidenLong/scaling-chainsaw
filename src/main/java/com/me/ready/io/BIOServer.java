package com.me.ready.io;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Autor syl
 * @Date 2019/2/22 16:28
 * 同步阻塞IO
 **/
public class BIOServer {

    public static void main(String[] args) {
        server3();
    }

    public static void server1() {
        ServerSocket server = null;
        Socket socket = null;
        InputStream in = null;
        OutputStream out = null;
        try {
            server = new ServerSocket(8000);
            System.out.println("服务器端启动成功，监听端口为8000，等待客户端连接....");
            // 阻塞
            socket = server.accept();

            // 阻塞
            in = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = in.read(buffer)) > 0) {
                System.out.println(new String(buffer, 0, len));
            }
            out = socket.getOutputStream();
            out.write("hello".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void server2() {
        ServerSocket server = null;
        try {
            server = new ServerSocket(8000);
            System.out.println("服务器端启动成功，监听端口为8000，等待客户端连接....");
            while (true) {
                Socket socket = server.accept();
                // 创建线程IO
                new Thread(new ServerHandler(socket)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void server3() {
        ServerSocket server = null;
        ExecutorService executorService = Executors.newFixedThreadPool(60);
        try {
            server = new ServerSocket(8000);
            System.out.println("服务器端启动成功，监听端口为8000，等待客户端连接....");
            while (true) {
                Socket socket = server.accept();
                executorService.submit(new ServerHandler(socket));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*public static void server4() {
        ServerSocket server = null;
        ExecutorService executorService = Executors.newFixedThreadPool(60);
        try {
            server = new ServerSocket(8000);
            System.out.println("服务器端启动成功，监听端口为8000，等待客户端连接....");
            while (true) {
                Socket socket = server.accept();
                executorService.submit(new ServerHandler(socket));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
