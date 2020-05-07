package org.spring.di.configuration;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="mail")
public class MailConfig {

	private int port;
	private String from;
	private List<String> defaultReciepients;

	private String hostname;
	/**
	 * @return the hostname
	 */
	public String getHostname() {
		return hostname;
	}
	/**
	 * @param hostname the hostname to set
	 */
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}
	/**
	 * @param port the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}
	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}
	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}
	/**
	 * @return the defaultReciepients
	 */
	public List<String> getDefaultReciepients() {
		return defaultReciepients;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MailConfig [port=" + port + ", from=" + from + ", defaultReciepients=" + defaultReciepients
				+ ", hostname=" + hostname + "]";
	}
	/**
	 * @param defaultReciepients the defaultReciepients to set
	 */
	public void setDefaultReciepients(List<String> defaultReciepients) {
		this.defaultReciepients = defaultReciepients;
	}


}
