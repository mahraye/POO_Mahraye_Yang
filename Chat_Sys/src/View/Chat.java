package View;

/**
 * CelsiusConverter.java is a 1.4 application that 
 * demonstrates the use of JButton, JTextField and
 * JLabel.  It requires no other files.
 */

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import java.time.*;

public class Chat extends JFrame implements ActionListener {
	
    JPanel chatPanel;
    JTextArea textDisplay;
    JTextField textInput;
    JButton Enter;
    JScrollPane scrollPane;
    LocalTime now;
    GridBagConstraints c;
    String username;

    public Chat(String username) {
    	this.username = username;
        //Set up the chat window.
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setPreferredSize(new Dimension(800, 600));

        setTitle("Chat System");
        
        //Create and set up the panel.
        chatPanel = new JPanel(new GridBagLayout());

        //Add the widgets.
        addWidgets();

        //Set the default button.
        getRootPane().setDefaultButton(Enter);
        
        //Add the panel to the window.
        getContentPane().add(chatPanel, BorderLayout.CENTER);
       
        //Display the window.
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Create and add the widgets.
    */
    
    private void addWidgets() {
        //Create widgets.
    	
    	// chatPanel
        textInput = new JTextField();
        textDisplay = new JTextArea();
        scrollPane = new JScrollPane(textDisplay);
        Enter = new JButton("Enter");
        c = new GridBagConstraints();
        
        textDisplay.append("Connected as " + username + "\n");
        
        //Listen to events from the Enter button.
        Enter.addActionListener(this);

        textDisplay.setEditable(false);
        textDisplay.setFont(new Font("Serif", Font.ITALIC, 16));
        textDisplay.setLineWrap(true);
        textDisplay.setWrapStyleWord(true);
        
        scrollPane.setVerticalScrollBarPolicy(
        		ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        // Manage layout and add widgets to the container
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth=3;
        c.weightx = 1;
        c.weighty = 0.9;
        
        chatPanel.add(scrollPane,c);
        
        c.gridx = 0;
        c.gridy = 1;
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 1;
        c.weightx = 0.95;
        c.weighty = 0.1;
        
        chatPanel.add(textInput,c);
        
        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 0.2;
       
        chatPanel.add(Enter,c);
    }

    
    public void actionPerformed(ActionEvent event) {
        String text = textInput.getText();
        if (text == "") {
        	textDisplay.append("�crivez un message");
        }
        else {
	        now= LocalTime.now();
	        textInput.setText("");
	        textDisplay.append(now + " : " + text + "\n");
        }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    
    
    /*
    public void printTextField(String text) {
    	textDisplay.setText(text);
    }
    
    private static void createAndShowGUI() {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(false);

        Chat chat = new Chat();
    }
    
    public void printTextField(String text) {
        textArea.setText(text);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    */
}