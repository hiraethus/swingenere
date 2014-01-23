package com.clackjones.swingenere;


import javax.swing.SwingUtilities;

import com.clackjones.swingenere.view.SwingenereView;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		final SwingenereView view = new SwingenereView();

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				view.showAndManageGui();
			}
		});
	}
}
