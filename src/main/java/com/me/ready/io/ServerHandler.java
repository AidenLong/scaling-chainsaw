package com.me.ready.io;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Autor syl
 * @Date 2019/2/22 16:48
 **/
public class ServerHandler implements Runnable {

    Socket socket;

    public ServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream in = null;
        OutputStream out = null;
        try {
            // 阻塞
            in = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = in.read(buffer)) > 0) {
                System.out.println("接收到客户端信息：" + new String(buffer, 0, len));
            }
            out = socket.getOutputStream();
            out.write("hello".getBytes());
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
