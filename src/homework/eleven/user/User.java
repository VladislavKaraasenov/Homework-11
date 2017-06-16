package homework.eleven.user;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

@SuppressWarnings("serial")
public class User extends JFrame implements ActionListener {

	private JTextField login;
	private JPasswordField password;
	private JButton button;

	public User() {
		login();
	}

	public void login() {
		setBounds(500, 150, 300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		login = new JTextField();
		login.setBounds(75, 50, 150, 20);
		login.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				changed();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				changed();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				changed();
			}
		});
		add(login);

		password = new JPasswordField();
		password.setBounds(75, 90, 150, 20);
		password.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				changed();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				changed();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				changed();
			}
		});
		add(password);

		JLabel accountLabel = new JLabel("account:");
		accountLabel.setBounds(20, 50, 55, 20);
		add(accountLabel);

		JLabel passwordLabel = new JLabel("password:");
		passwordLabel.setBounds(10, 90, 65, 20);
		add(passwordLabel);

		button = new JButton("Login");
		button.setBounds(105, 130, 90, 30);
		button.getModel().addActionListener(this);
		button.setEnabled(false);
		add(button);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "\"You have logged in\"", "Message", JOptionPane.INFORMATION_MESSAGE);
	}

	private void changed() {
		String passwordText = new String(password.getPassword());
		if (login.getText().equals("") || passwordText.equals("")) {
			button.setEnabled(false);
		} else {
			button.setEnabled(true);
		}
	}
}
