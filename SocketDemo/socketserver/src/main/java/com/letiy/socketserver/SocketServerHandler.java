package com.letiy.socketserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SocketServerHandler implements Runnable {
	private static Logger logger = LoggerFactory.getLogger(SocketServerHandler.class);
	private Socket socket = null;

	public SocketServerHandler(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			DataInputStream inputStream = new DataInputStream(socket.getInputStream());
			String request = inputStream.readUTF();
			logger.info("Client request is [ " + request + " ]");

			DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
			outputStream.writeUTF("Hi, i am socket server, client say: [ " + request + " ] " + " " + new Date());

			Thread.sleep(1000 * 5);
			socket.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
