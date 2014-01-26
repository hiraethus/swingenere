package com.clackjones.swingenere.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class SwingenereView {
	//TODO: replace with i18n
	private static final String FRAME_TITLE = "Swingenere v0.1";
	private static final String MESSAGE = "Message";
	private static final String KEY_MESSAGE = "Key";
	private static final String ENCRYPT_BUTTON_TEXT = "Encrypt";
	private static final String RESULT_LABEL_TEST = "Result";


	private JPanel mainPanel;
	private JTextArea messageArea;
	private JTextField keyField;
	private JButton encryptButton;
	private JTextArea resultArea;

	private void initGui() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());
		mainPanel.setPreferredSize(new Dimension(200,200));

		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.LINE_START;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.weightx = 1.;
		c.weighty = 0.;

		JLabel messageLabel = new JLabel(MESSAGE);
		mainPanel.add(messageLabel, c);

		c.anchor = GridBagConstraints.LINE_START;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		c.weightx = 1.;
		c.weighty = 0.3;

		messageArea = new JTextArea();
		mainPanel.add(new JScrollPane(messageArea), c);

		c.anchor = GridBagConstraints.LINE_START;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 2;
		c.weightx = .1;
		c.weighty = 0.;

		JLabel keyLabel = new JLabel(KEY_MESSAGE);
		mainPanel.add(keyLabel, c);

		c.anchor = GridBagConstraints.LINE_START;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		c.weightx = .6;
		c.weighty = 0.;

		keyField = new JTextField();
		mainPanel.add(keyField, c);

		c.anchor = GridBagConstraints.LINE_START;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		c.weightx = 0.;
		c.weighty = 0.;

		encryptButton = new JButton(ENCRYPT_BUTTON_TEXT);
		mainPanel.add(encryptButton, c);

		c.anchor = GridBagConstraints.LINE_START;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 2;
		c.weightx = 1.;
		c.weighty = 0.;

		JLabel resultLbl = new JLabel(RESULT_LABEL_TEST);
		mainPanel.add(resultLbl, c);

		c.anchor = GridBagConstraints.LINE_START;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 2;
		c.weightx = 1.;
		c.weighty = 0.3;

		resultArea = new JTextArea();
		mainPanel.add(new JScrollPane(resultArea), c);
		mainPanel.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
	}

	public void showAndManageGui() {
		initGui();
		JFrame frame = new JFrame(FRAME_TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(mainPanel);
		frame.setSize(new Dimension(400,500));
		frame.setVisible(true);
	}
}