package midterm_project;
import java.awt.Image;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TheJFrame extends JFrame{
	
	
	public TheJFrame(){
		super("ELIZA");
		//create object of type TheJPanel and create your frame
		TheJPanel jp = new TheJPanel();
		add(jp);//link the instance of the jpanel
		//set size, set visible and make sure to exit_on_close for the setDefaultCloseOperation
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);
		setVisible(true);
		jp.setBackground(Color.pink);
	}

}
