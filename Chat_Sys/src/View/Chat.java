package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.SystemColor;
import javax.swing.JMenuItem;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import java.awt.Color;

public class Chat {

	public String username;
	private JFrame frame;
	private JTextField textField;
	
	/**
	 * Create the application.
	 */
	public Chat(String username) {
		this.username = username;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(244, 10, 497, 541);
		frame.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		panel.add(textArea, "name_886610462468200");
		
		textField = new JTextField();
		textField.setBounds(245, 588, 416, 69);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = textField.getText();
				if (message.isEmpty()) {
					textField.setText("");
				}
				else {
				textArea.append(username + " : " + message + "\n");
				textField.setText("");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(669, 602, 72, 38);
		frame.getContentPane().add(btnNewButton);
		frame.getRootPane().setDefaultButton(btnNewButton);
		
		JList list = new JList();
		list.setBounds(20, 95, 207, 562);
		frame.getContentPane().add(list);
		frame.setBounds(100, 100, 1012, 746);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(3, 3, 16, 2));
		menuBar.setForeground(SystemColor.textInactiveText);
		menuBar.setBackground(SystemColor.menu);
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Connected as " + username);
		mnNewMenu.setForeground(SystemColor.desktop);
		mnNewMenu.setIcon(new ImageIcon("D:\\Projet INSA\\Webp.net-resizeimage.png"));
		mnNewMenu.setBackground(SystemColor.textHighlight);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Disconnect");
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Change username");
		mntmNewMenuItem_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangeUsername window = new ChangeUsername();
				username = window.getusername();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
	}
}
/*	
	
	  Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat window = new Chat();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
*/