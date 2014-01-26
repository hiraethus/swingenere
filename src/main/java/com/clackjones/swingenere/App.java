package com.clackjones.swingenere;

import javax.swing.SwingUtilities;

import com.clackjones.swingenere.view.SwingenereController;
import com.clackjones.swingenere.view.SwingenereModelImpl;
import com.clackjones.swingenere.view.SwingenereView;

public class App {
	public static void main(String[] args) {
		SwingenereController controller = new SwingenereController();
		controller.registerModel(new SwingenereModelImpl());

		final SwingenereView view = new SwingenereView(controller);

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				view.showAndManageGui();
			}
		});
	}
}
