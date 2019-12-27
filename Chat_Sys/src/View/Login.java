package View;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JTextField;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;



import javax.swing.ImageIcon;

public class Login {

	private JFrame frame;
	public String username;
	JButton login;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setBounds(100, 100, 709, 448);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Log in" );
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 369, 418);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(-51, -25, 544, 328);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("D:\\T\u00E9l\u00E9chargements\\Webp.net-resizeimage.jpg"));
		
		JLabel lblNewLabel_3 = new JLabel("Keep up the teamwork");
		lblNewLabel_3.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel_3.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 19));
		lblNewLabel_3.setBounds(57, 294, 264, 38);
		panel.add(lblNewLabel_3);
		
		JLabel lblLinkUsTogether = new JLabel("Link us together");
		lblLinkUsTogether.setForeground(Color.WHITE);
		lblLinkUsTogether.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 19));
		lblLinkUsTogether.setBounds(87, 342, 199, 38);
		panel.add(lblLinkUsTogether);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome on the chat !");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(439, 45, 223, 29);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(411, 178, 251, 44);
		
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Log in ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username=textField.getText();
			    if (username.equals("boris")) {
			    	frame.dispose();
				    Chat window=new Chat();
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
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnNewButton.setBounds(476, 271, 123, 44);
		frame.getContentPane().add(btnNewButton);
		frame.getRootPane().setDefaultButton(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(495, 136, 81, 22);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
