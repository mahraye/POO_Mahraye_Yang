package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
  
public class Login extends JFrame implements ActionListener {
	JButton Connect;
    JPanel panel;
    JLabel label;
    public String username;
    final JTextField  text;
    Login() {
	    label = new JLabel();
	    label.setText("Username:");
	    text = new JTextField(15);
	 
	    Connect=new JButton("Connect");
	    Connect.addActionListener(this);
	   
	    panel=new JPanel(new GridLayout(2,1));
	    panel.add(label);
	    panel.add(text);
	    panel.add(Connect);
	    add(panel,BorderLayout.CENTER);
	    getRootPane().setDefaultButton(Connect);
	    setTitle("LOGIN");
    }
    
    public void actionPerformed(ActionEvent ae){
	    username=text.getText();
	    if (username.equals("boris")) {
	    	this.dispose();
		    Chat chat=new Chat(username);
	    }
	    else
	    {
		    System.out.println("Erreur");
		    JOptionPane.showMessageDialog(this,"Username already used. \n "
		    		+ "Please enter another username.",
		    "Error",JOptionPane.ERROR_MESSAGE);
        }    
    }
    
	public static void main(String arg[])
	{
		  try {
			  Login frame=new Login();
			  frame.setSize(300,150);
			  frame.setLocationRelativeTo(null);
			  frame.setVisible(true);
		  }
		   
		  catch(Exception e){
			  JOptionPane.showMessageDialog(null, e.getMessage());
		  }
     }
}