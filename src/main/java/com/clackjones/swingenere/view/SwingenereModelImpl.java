package com.clackjones.swingenere.view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import com.clackjones.vigenere.VigenereEncrypt;
import com.clackjones.vigenere.VigenereEncryptImpl;
import com.clackjones.vigenere.exception.InvalidCharacterException;
import com.clackjones.vigenere.exception.InvalidKeyException;
import com.clackjones.vigenere.exception.InvalidMessageException;
import com.clackjones.vigenere.exception.KeyNotSetException;
import com.clackjones.vigenere.exception.MessageNotSetException;

public class SwingenereModelImpl implements SwingenereModel {
	private final PropertyChangeSupport mPcs = new PropertyChangeSupport(this);

	private VigenereEncrypt vigenereEncrypt = new VigenereEncryptImpl();
	private String result = "";

	@Override
	public String getMessage() {
		return vigenereEncrypt.getMessage();
	}

	@Override
	public void setMessage(String message) {
		String oldMessage = vigenereEncrypt.getMessage();
		try {
			vigenereEncrypt.setMessage(message);
		} catch (InvalidMessageException e) {
			// TODO add exception handling to view
			e.printStackTrace();
		}

		mPcs.firePropertyChange(MESSAGE_CHANGED, oldMessage, message);
	}

	@Override
	public String getKey() {
		String key = "";
		try {
			key = vigenereEncrypt.getKeyString();
		} catch (InvalidKeyException e) {
			// TODO add exception handling to view
			e.printStackTrace();
		}
		return key;
	}

	@Override
	public void setKey(String key) {
		String oldKey = "";
		try {
			oldKey = vigenereEncrypt.getKeyString();
		} catch (InvalidKeyException e) {
			// TODO add exception handling to view
			e.printStackTrace();
		}

		try {
			vigenereEncrypt.setKeyString(key);
		}catch (InvalidKeyException e) {
			// TODO add exception handling to view
			e.printStackTrace();
		}

		mPcs.firePropertyChange(KEY_CHANGED, oldKey, key);
	}

	@Override
	public String getResult() {
		return this.result;
	}

	@Override
	public void setResult() {
		//TODO - remove this method from the interface - not needed
	}

	@Override
	public void encrypt() {
		String oldResult = this.result;

		String newResult = "";
		try {
			newResult = vigenereEncrypt.encrypt();
		} catch (KeyNotSetException e) {
			// TODO add exception handling to view
			e.printStackTrace();
		} catch (MessageNotSetException e) {
			// TODO add exception handling to view
			e.printStackTrace();
		} catch (InvalidCharacterException e) {
			// TODO add exception handling to view
			e.printStackTrace();
		}

		this.result = newResult;
		mPcs.firePropertyChange(RESULT_CHANGED, oldResult, newResult);
	}

	@Override
	public void decrypt() {
		String oldResult = this.result;

		String newResult = "";
		try {
			newResult = vigenereEncrypt.decrypt();
		} catch (KeyNotSetException e) {
			// TODO add exception handling to view
			e.printStackTrace();
		} catch (MessageNotSetException e) {
			// TODO add exception handling to view
			e.printStackTrace();
		} catch (InvalidCharacterException e) {
			// TODO add exception handling to view
			e.printStackTrace();
		}

		this.result = newResult;
		mPcs.firePropertyChange(RESULT_CHANGED, oldResult, newResult);
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		mPcs.addPropertyChangeListener(listener);
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		mPcs.removePropertyChangeListener(listener);
	}

}
