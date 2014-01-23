package com.clackjones.swingenere.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class SwingenereView {
	//TODO: replace with i18n
	private static final String FRAME_TITLE = "Swingenere v0.1";

	private JPanel mainPanel;

	private void initGui() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());
		mainPanel.setPreferredSize(new Dimension(200,200));

		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.LINE_START;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.5;
		c.weighty = 0.5;
		mainPanel.add(new JButton("Lol"), c);
	}

	public void showAndManageGui() {
		initGui();
		JFrame frame = new JFrame(FRAME_TITLE);
		frame.getContentPane().add(mainPanel);
		frame.setSize(new Dimension(200,200));
		frame.setVisible(true);
	}
}
