package com.clackjones.swingenere;

import java.beans.PropertyChangeListener;

import javax.swing.SwingUtilities;

import com.clackjones.swingenere.view.SwingenereController;
import com.clackjones.swingenere.view.SwingenereModel;
import com.clackjones.swingenere.view.SwingenereView;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		SwingenereController controller = new SwingenereController();
		controller.registerModel(new SwingenereModel() {

			@Override
			public void setResult() {
				// TODO Auto-generated method stub
			}

			@Override
			public void setMessage(String message) {
				// TODO Auto-generated method stub
			}

			@Override
			public void setKey(String key) {
				// TODO Auto-generated method stub

			}

			@Override
			public void removePropertyChangeListener(
					PropertyChangeListener listener) {
				// TODO Auto-generated method stub

			}

			@Override
			public String getResult() {
				// TODO Auto-generated method stub
				return "TEST RESULT";
			}

			@Override
			public String getMessage() {
				// TODO Auto-generated method stub
				return "TEST MESSAGE";
			}

			@Override
			public String getKey() {
				// TODO Auto-generated method stub
				return "TEST KEY";
			}

			@Override
			public void encrypt() {
				// TODO Auto-generated method stub

			}

			@Override
			public void decrypt() {
				// TODO Auto-generated method stub

			}

			@Override
			public void addPropertyChangeListener(
					PropertyChangeListener listener) {
				// TODO Auto-generated method stub

			}
		});
		final SwingenereView view = new SwingenereView(controller);

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				view.showAndManageGui();
			}
		});
	}
}
