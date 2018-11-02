package com.bmuschko.java11.tls;

import org.junit.jupiter.api.Test;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.IOException;

public class TLS13Test {
    @Test
    void canStartServer() {
        try {
            SSLServerSocket socket = (SSLServerSocket) SSLServerSocketFactory.getDefault().createServerSocket(8080);
            socket.setEnabledProtocols(new String[] { "TLSv1.3" });
            socket.setEnabledCipherSuites(new String[] { "TLS_AES_256_GCM_SHA384" });

            try {
                new Thread(() -> System.out.println("Server started on port " + socket.getLocalPort())).start();
            } finally {
                if (socket != null && !socket.isClosed()) {
                    socket.close();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
