package greenUser;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Random;
import javax.swing.JFrame;

public class UserInterface extends JFrame {
	
	public static void main(String[] args) {
	
	// Create Frame and Properties
	JFrame frame = new JFrame("Menu");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(400, 300);
	
	// Create Text Area
	JTextArea textArea = new JTextArea();
	frame.add(new JScrollPane(textArea), BorderLayout.CENTER);
	
	// Menu Bar + Add Items
	JMenuBar menuBar = new JMenuBar();
	JMenu menu = new JMenu("Options");
	menuBar.add(menu);
	JMenuItem dateAndTime = new JMenuItem("Display Current Date & Time");
	JMenuItem saveTextFile = new JMenuItem("Save to Text File");
	JMenuItem changeBackground = new JMenuItem("Change Background Color");
	JMenuItem exitOperation = new JMenuItem("Exit");
	
	menu.add(dateAndTime);
	menu.add(saveTextFile);
	menu.add(changeBackground);
	menu.add(exitOperation);
	
	frame.setJMenuBar(menuBar);
	frame.setVisible(true);
	
	// ActionListeners
	dateAndTime.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String dateTime = new java.util.Date().toString();
			textArea.setText(dateTime);
		}
	});
	
	saveTextFile.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try { FileWriter writer = new FileWriter("log.txt", true);
				writer.write(textArea.getText());
				writer.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	});
	
	changeBackground.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			float hue = (float) Math.random();
			Color randomGreenColor = Color.getHSBColor(hue, 1.0f, 1.0f);
			textArea.setBackground(randomGreenColor);
			frame.getContentPane().setBackground(randomGreenColor);
		}
	});
	
	exitOperation.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	});
	
	}
}