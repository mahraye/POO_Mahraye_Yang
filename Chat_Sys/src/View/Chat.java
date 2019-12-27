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

public class Chat {

	public String username;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public Chat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 1012, 746);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(3, 3, 16, 2));
		menuBar.setForeground(SystemColor.textInactiveText);
		menuBar.setBackground(SystemColor.menu);
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Connected as Boris");
		mnNewMenu.setForeground(SystemColor.desktop);
		mnNewMenu.setIcon(new ImageIcon("D:\\Projet INSA\\Webp.net-resizeimage.png"));
		mnNewMenu.setBackground(SystemColor.textHighlight);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Disconnect");
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Change username");
		mnNewMenu.add(mntmNewMenuItem_1);
	}

}
