package com.m0pt0pmatt.advancednotifications.messages;

import org.bukkit.configuration.ConfigurationSection;

/**
 * A message represents a String of characters from one player to another
 * @author Matthew
 *
 */
public class Message {

	private String sender;
	private String receiver;
	private String content;
	private MessageStatus status;
	private long timestamp;
	
	public Message(String sender, String receiver, String content, MessageStatus status, long timestamp){
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
		this.status = status;
	}

	public String getSender() {
		return sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public MessageStatus getStatus() {
		return status;
	}

	public void setStatus(MessageStatus status) {
		this.status = status;
	}
	
	public static void serializeMessage(ConfigurationSection messagesSection, Message message, String location){
		
		ConfigurationSection messageSection = messagesSection.createSection(location);
		
		messageSection.set("sender", message.getSender());
		messageSection.set("receiver", message.getReceiver());
		messageSection.set("status", message.getStatus());
		messageSection.set("content", message.getContent());
		messageSection.set("timestamp", message.getTimestamp());
	}
	
	public static Message unserializeMessage(ConfigurationSection messageSection){
		String sender = (String) messageSection.get("sender");
		String receiver = (String) messageSection.get("receiver");
		String status = (String) messageSection.get("status");
		String content = (String) messageSection.get("content");
		Long timestamp = messageSection.getLong("timestamp");
		return new Message(sender, receiver, content, MessageStatus.valueOf(status), timestamp);
	}
	
}