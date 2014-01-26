package com.clackjones.swingenere.view;

import java.beans.PropertyChangeListener;

public interface SwingenereModel {
	public static final String MESSAGE_CHANGED = "messageChanged";
	public static final String KEY_CHANGED = "keyChanged";
	public static final String RESULT_CHANGED ="resultChanged";

	/** 
	 * Get the message to be encrypted or decrypted
	 */
	String getMessage();
	
	/**
	 * Set the message to be encrypted or decrypted
	 * @param message
	 */
	void setMessage(String message);
	
	/**
	 * Get the key to encrypt / decrypt the message
	 * @return
	 */
	String getKey();
	
	/**
	 * Set the key to encrypt / decrypt the messages
	 * @param key
	 */
	void setKey(String key);
	
	String getResult();
	
	void setResult();
	
	void encrypt();
	void decrypt();
	
	void addPropertyChangeListener(PropertyChangeListener listener);
	void removePropertyChangeListener(PropertyChangeListener listener);
}
