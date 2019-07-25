package com.jz.tools.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class SSHUtil {
	private static Channel channel;
	private static Session session = null;
	private static int timeout = 60000;
	private static String ipAddress;
	private static int port;
	private static String username;
	private static String password;
	private static InputStream instream;

	public Channel getChannel() {
		return channel;
	}

	public static String getIpAddress() {
		return ipAddress;
	}

	public static void setIpAddress(String ipAddress) {
		SSHUtil.ipAddress = ipAddress;
	}

	public static int getPort() {
		return port;
	}

	public static void setPort(int port) {
		SSHUtil.port = port;
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		SSHUtil.username = username;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		SSHUtil.password = password;
	}

	public static void Connect(final String ipAddress, int port, final String username, final String password)
			throws Exception {
		if (!ipAddress.equals(SSHUtil.ipAddress)) {
			if (session != null && session.isConnected()) {
				SSHUtil.close();
			}
			connect(ipAddress, port, username, password);
		} else if (!session.isConnected()) {
			connect(ipAddress, port, username, password);
		}

	}

	public static void connect(final String ipAddress, int port, final String username, final String password)
			throws JSchException {
		JSch jsch = new JSch();
		session = jsch.getSession(username, ipAddress, port);
		session.setPassword(password);
		session.setConfig("StrictHostKeyChecking", "no");
		session.setTimeout(timeout);
		session.connect();
		channel = session.openChannel("shell");
		channel.connect(1000);
		SSHUtil.setIpAddress(ipAddress);
		SSHUtil.setPort(port);
		SSHUtil.setUsername(username);
		SSHUtil.setPassword(password);
	}

	public static String runShell(String cmd, String charset) throws Exception {
		String temp = null;
		OutputStream outstream = null;
		try {
			instream = channel.getInputStream();
			outstream = channel.getOutputStream();
			outstream.write(cmd.getBytes());
			outstream.flush();
			TimeUnit.SECONDS.sleep(1);
			if (instream.available() > 0) {
				byte[] data = new byte[instream.available()];
				int nLen = instream.read(data);
				
				if (nLen < 0) {
					throw new Exception("network error.");
				}
				
				temp = new String(data, 0, nLen, "utf-8");
			} 
		} finally {
			// outstream.close();
			// instream.close();
		}
		return temp;
	}

	public static int getDataLength() throws IOException {
		return instream.available();
	}

	public static String getData() {
		String temp = null;

		try {
			if (instream.available() > 0) {
				byte[] data = new byte[2048];
				int nLen = instream.read(data);

				if (nLen < 0) {
					throw new Exception("network error.");
				}

				temp = new String(data, 0, nLen, "utf-8");
			}
		} catch (Exception e) {
			// TODO: handle exception
			SSHUtil.close();
			temp = e.getMessage();

		}

		return temp;
	}

	public static void close() {
		channel.disconnect();
		session.disconnect();
		try {
			if (instream != null) {

				instream.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(final String[] args) throws Exception {
		// shutdown.sh
		SSHUtil.Connect("192.168.115.228", 22, "user", "password#@!");
		String res = SSHUtil.runShell("echo '123'\n echo '哈哈'\n", "utf-8");
		System.out.println(res);
		SSHUtil.close();
		String res1 = SSHUtil.runShell("echo '123'\n echo '456'\n", "utf-8");
		System.out.println(res1);
	}
}
