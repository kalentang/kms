package com.letiy.socketclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class AppClient {

	private static Logger logger = LoggerFactory.getLogger(AppClient.class);
	private static final String host = "127.0.0.1";
	private static final int port = 5020;

	public static void main(String[] args) {

		logger.info("please input request...");
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNextLine()) {
			String requst = scanner.nextLine();
			logger.info("[client]:" + requst);

			if (requst.equals("end")) {
				break;
			}

			try {
				Socket socket = new Socket(host, port);

				DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
				outputStream.writeUTF(requst);

				DataInputStream inputStream = new DataInputStream(socket.getInputStream());
				String response = inputStream.readUTF();

				logger.info("[server]:" + response);
				socket.close();

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		scanner.close();
	}

}
