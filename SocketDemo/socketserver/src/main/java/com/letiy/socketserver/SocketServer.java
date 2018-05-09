package com.letiy.socketserver;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SocketServer {

	private static Logger logger = LoggerFactory.getLogger(SocketServer.class);
	private int port = 5020;

	public SocketServer() {
		// TODO Auto-generated constructor stub
	}

	public SocketServer(int port) {
		this.port = port;
	}

	public void startServer() {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(port);
			logger.info("server start success at port:" + port);
			
			ExecutorService executorService = Executors.newFixedThreadPool(10);

			while (true) {
				logger.info("listening request...");
				Socket socket = serverSocket.accept();

				executorService.submit(new SocketHandle(socket));
			}
		} catch (Exception e) {

			logger.info("server start exception:" + e);
		}
	}

}
