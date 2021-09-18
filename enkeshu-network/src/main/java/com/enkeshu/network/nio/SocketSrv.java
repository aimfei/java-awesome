package com.enkeshu.network.nio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * @author mukang
 */
public class SocketSrv {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9000);
            Socket accept = serverSocket.accept();
            handler(accept);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handler(Socket socket) {
        byte[] bytes = new byte[1024];
        System.out.println("准备连接");
        //Objects.requireNonNull()
        try {
            int read = socket.getInputStream().read(bytes);
            System.out.println("read 完成");
            while (read != -1) {
                System.out.println("结束到客户端请求数据" + new String(bytes, 0, read));
            }
            socket.getOutputStream().write("hellowolld".getBytes(StandardCharsets.UTF_8));
            socket.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
