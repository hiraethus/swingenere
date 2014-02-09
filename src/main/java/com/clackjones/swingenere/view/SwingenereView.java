package com.clackjones.swingenere.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SwingenereView implements PropertyChangeListener {
	private JPanel mainPanel;
	private JTextArea messageArea;
	private JTextField keyField;
	private JButton encryptButton;
	private JButton decryptButton;
	private JTextArea resultArea;

	private JMenuBar menuBar;

	private ResourceBundle resourceBundle = ResourceBundleFactory.getResourceBundle();
	private SwingenereController controller;
	private JMenuItem exitMenuItem;

	public SwingenereView(SwingenereController controller) {
		this.controller = controller;
		this.controller.registerView(this);
	}

	private void initGui() {
		initMenuBar();

		mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());
		mainPanel.setPreferredSize(new Dimension(200, 200));

		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.LINE_START;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.weightx = 1.;
		c.weighty = 0.;

		JLabel messageLabel = new JLabel(resourceBundle.getString("swingenere.messageLbl"));
		mainPanel.add(messageLabel, c);

		c.anchor = GridBagConstraints.LINE_START;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 3;
		c.weightx = 1.;
		c.weighty = 0.3;

		messageArea = new JTextArea();
		mainPanel.add(new JScrollPane(messageArea), c);

		c.anchor = GridBagConstraints.LINE_START;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 3;
		c.weightx = .1;
		c.weighty = 0.;

		JLabel keyLabel = new JLabel(resourceBundle.getString("swingenere.keyLbl"));
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

		encryptButton = new JButton(resourceBundle.getString("swingenere.encryptBtn"));
		mainPanel.add(encryptButton, c);

		c.anchor = GridBagConstraints.LINE_START;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 2;
		c.gridy = 3;
		c.gridwidth = 1;
		c.weightx = 0.;
		c.weighty = 0.;

		decryptButton = new JButton(resourceBundle.getString("swingenere.decryptBtn"));
		mainPanel.add(decryptButton, c);

		c.anchor = GridBagConstraints.LINE_START;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 3;
		c.weightx = 1.;
		c.weighty = 0.;

		JLabel resultLbl = new JLabel(resourceBundle.getString("swingenere.resultLbl"));
		mainPanel.add(resultLbl, c);

		c.anchor = GridBagConstraints.LINE_START;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 3;
		c.weightx = 1.;
		c.weighty = 0.3;

		resultArea = new JTextArea();
		mainPanel.add(new JScrollPane(resultArea), c);
		mainPanel.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
	}

	private void populateGui() {
		if (this.controller != null) {
			if (this.messageArea != null) {
				this.messageArea.setText(this.controller.getMessage());
			}
			if (this.keyField != null) {
				this.keyField.setText(this.controller.getKey());
			}
			if (this.resultArea != null) {
				this.resultArea.setText(this.controller.getResult());
			}
		}
	}

	public JMenuBar initMenuBar() {
		menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);

		exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.setMnemonic(KeyEvent.VK_X);
		fileMenu.add(exitMenuItem);

		menuBar.add(fileMenu);

		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic(KeyEvent.VK_H);
		menuBar.add(helpMenu);

		return menuBar;
	}

	/**
	 * Add listeneres to components so that they can 
	 * manipulate the model
	 */
	private void setupComponents() {
		encryptButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//dry message value from message area
				String messageText = messageArea.getText();
				controller.setMessage(messageText);

				String keyString = keyField.getText();
				controller.setKey(keyString);
				controller.encrypt();
			}
		});

		decryptButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//dry message value from message area
				String messageText = messageArea.getText();
				controller.setMessage(messageText);

				String keyString = keyField.getText();
				controller.setKey(keyString);
				controller.decrypt();
			}
		});

		exitMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
	}

	public void showAndManageGui() {
		initGui();
		populateGui();
		setupComponents();
		JFrame frame = new JFrame(resourceBundle.getString("swingenere.title"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(mainPanel);
		frame.setJMenuBar(menuBar);
		frame.setSize(new Dimension(400, 500));
		frame.setVisible(true);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals(SwingenereModel.MESSAGE_CHANGED)) {
			this.messageArea.setText(evt.getNewValue().toString());
		}

		if (evt.getPropertyName().equals(SwingenereModel.KEY_CHANGED)) {
			this.keyField.setText(evt.getNewValue().toString());
		}

		if (evt.getPropertyName().equals(SwingenereModel.RESULT_CHANGED)) {
			this.resultArea.setText(evt.getNewValue().toString());
		}

		if (evt.getPropertyName().equals(SwingenereModel.ERROR_CHANGED)) {
			showErrorDialog((SystemError) evt.getNewValue());
		}
	}

	private void showErrorDialog(SystemError systemError) {
		if (this.mainPanel != null) {
			JOptionPane.showMessageDialog(mainPanel, systemError.getErrorMessage());
		}
	}
}