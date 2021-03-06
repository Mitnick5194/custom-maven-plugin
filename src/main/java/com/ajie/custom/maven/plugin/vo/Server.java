package com.ajie.custom.maven.plugin.vo;

/**
 * 服务器信息
 *
 * @author niezhenjie
 *
 */
public class Server {
	/** 默认端口 */
	public static final int DEFAULT_PORT = 22;
	/** 默认上传的根目录 */
	public static final String DEFAULT_UPLOAD_PATH = "/var/www/";
	/** 主机地址 */
	private String host;
	/** 用户名 */
	private String username;
	/** 密码 */
	private String password;
	/** 端口 */
	private int port;
	/** 是否上传 */
	private boolean isupload;
	/**
	 * 上传至服务器路径，最终文件会上传至uploadpath+projectName路径，如uploadBasePath：/var/www/
	 * ,projectName: blog，最后项目上传到/var/www/blog文件夹下
	 */
	private String uploadBasePath;

	public Server() {

	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public static int getDefaultPort() {
		return DEFAULT_PORT;
	}

	public void setUpload(boolean b) {
		isupload = b;
	}

	public boolean isUpload() {
		return isupload;
	}

	public void setUploadBasePath(String uploadpath) {
		this.uploadBasePath = uploadpath;
	}

	/**
	 * 获取上传文件至服务器的路径，路径结束符为/
	 * 
	 * @return
	 */
	public String getUploadBasePath() {
		if (null == uploadBasePath)
			uploadBasePath = DEFAULT_UPLOAD_PATH;
		if (!uploadBasePath.endsWith("/")) {
			uploadBasePath += "/";
		}
		return uploadBasePath;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{host:").append(host).append(",");
		sb.append("username:").append(username).append(",");
		sb.append("isupload:").append(isupload).append(",");
		sb.append("uploadBasePath:").append(getUploadBasePath()).append("}");
		return sb.toString();
	}

	public static class ServerBuilder {
		Server server;

		private ServerBuilder(Server server) {
			this.server = server;
		}

		public static ServerBuilder getBuilder() {
			ServerBuilder builder = new ServerBuilder(new Server());
			return builder;
		}

		public ServerBuilder setHost(String host) {
			server.host = host;
			return this;
		}

		public ServerBuilder setPort(int port) {
			server.port = port;
			return this;
		}

		public ServerBuilder setUsername(String name) {
			server.username = name;
			return this;
		}

		public ServerBuilder setPassword(String password) {
			server.password = password;
			return this;
		}

		public ServerBuilder setUpload(boolean b) {
			server.isupload = b;
			return this;
		}

		public ServerBuilder setUploadBasePath(String path) {
			server.uploadBasePath = path;
			return this;
		}

		public Server build() {
			return server;
		}
	}

}
