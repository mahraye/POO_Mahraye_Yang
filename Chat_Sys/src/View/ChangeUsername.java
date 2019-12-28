package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangeUsername {

	String newUsername;
	private JFrame frame;
	private JTextField textField;
/*
	
	 Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeUsername window = new ChangeUsername();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the application.
	 */
	public ChangeUsername() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 443, 253);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("You want to change username ? ");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel.setBounds(90, 10, 280, 45);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter your new username : ");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(124, 50, 436, 45);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(66, 92, 310, 45);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Change");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newUsername=textField.getText();
			    if (newUsername.equals("abdel")) {
			    	frame.dispose();
			    }
			    else
			    {
				    System.out.println("Erreur");
				    JOptionPane.showMessageDialog(frame,"Username already used. \n "
				    		+ "Please enter another username.",
				    "Error",JOptionPane.ERROR_MESSAGE);
				    textField.setText("");
		        }    
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 14));
		btnNewButton.setBounds(163, 147, 118, 41);
		frame.getContentPane().add(btnNewButton);
		frame.getRootPane().setDefaultButton(btnNewButton);
	}
	
	public String getusername() {
		return this.newUsername;
	}
}
