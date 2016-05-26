import java.awt.GridBagConstraints;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class textReader extends JPanel implements ActionListener {
	protected JTextField textField;
	protected JTextArea textArea;
    private final static String newline = "\n";
    private String text;
	
	public textReader()
	{
		super(new GridBagLayout());
		
        textArea = new JTextArea(5, 20);
        textArea.setEditable(false);
        textField = new JTextField(20);
		textField.addActionListener(this);
        JScrollPane scrollPane = new JScrollPane(textArea);
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;

        c.fill = GridBagConstraints.HORIZONTAL;
        
        add(scrollPane, c);
        

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(textField, c);
        
        
	}
	
	public textReader(String menu)
	{
		super(new GridBagLayout());
		textField = new JTextField("Please enter the number of the menu option", 20);
		textField.addActionListener(this);
        textArea = new JTextArea(5, 20);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;

        c.fill = GridBagConstraints.HORIZONTAL;
        add(textField, c);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollPane, c);
        
	}
	
	 public void actionPerformed(ActionEvent evt) {
	        String text = textField.getText();
	        textArea.append(text + newline);
	        textField.selectAll();
	        textField.setText("");
	        textArea.setCaretPosition(textArea.getDocument().getLength());
	   }
	 
	 public void displayText(String display)
	 {
		 textArea.append(">" + text + newline);
	 }
	 public void setText(String settingText)
	 {
		 text = settingText;
	 }
	 public String getText()
	 {
		 return text;
	 }
	   

}
