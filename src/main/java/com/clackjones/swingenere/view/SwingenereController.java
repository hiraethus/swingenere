package com.clackjones.swingenere.view;

import java.util.List;
import java.util.ArrayList;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SwingenereController implements PropertyChangeListener {
	private List<PropertyChangeListener> views = new ArrayList<PropertyChangeListener>();
	private SwingenereModel model = null;

	public void registerModel(SwingenereModel model) {
		this.model = model;
		model.addPropertyChangeListener(this);
	}

	public void unregisterModel(SwingenereModel model) {
		if  (this.model != null && model == this.model) {
			this.model.removePropertyChangeListener(this);
			this.model = null;
		}
	}

	public void registerView(PropertyChangeListener view) {
		if (!views.contains(view)) {
			views.add(view);
		}
	}

	public void unregisterView(PropertyChangeListener view) {
		if (views.contains(view)) {
			views.remove(view);
		}
	}


	public String getMessage() {
		String message = "";
		if (this.model != null) {
			message = this.model.getMessage();
		}

		return message;
	}

	public void setMessage(String message) {
		if (this.model != null) {
			this.model.setMessage(message);
		}
	}

	public String getKey() {
		String key = "";
		if (this.model != null) {
			key = this.model.getKey();
		}
		return key;
	}

	public void setKey(String key) {
		if (this.model != null) {
			this.model.setKey(key);
		}
	}

	public String getResult() {
		String result = "";
		if (this.model != null) {
			result = this.model.getResult();
		}
		return result;
	}

	public void setResult() {
		if (this.model != null) {
			this.model.setResult();
		}
	}

	public SystemError getSystemError() {
		SystemError systemError = null;
		if (this.model != null) {
			systemError = this.model.getSystemError();
		}

		return systemError;
	}

	public void encrypt() {
		if (this.model != null) {
			this.model.encrypt();
		}
	}

	public void decrypt() {
		if (this.model != null) {
			this.model.decrypt();
		}
	}

	public void propertyChange(PropertyChangeEvent evt) {
		//tell all the views
		for (PropertyChangeListener view: views) {
			view.propertyChange(evt);
		}
	}
}
