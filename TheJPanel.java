package midterm_project;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
/*
 *  -jlabel for displaying the program questions

    -jtextfield for the user's response to be typed

    -jbutton to allow the user to submit the answer

    -jlabel for displaying all the (longestWords) he/she used in this session

    -jbutton for the user to request all (longestWords) used in this session 
    		Note: When displaying in the jlabel separate all the longestWords by commas

 */
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class TheJPanel extends JPanel implements ActionListener{
	//instance variables
	private JLabel lblImage;
	private JLabel lblDisplay;
	private JLabel lblQuestions;
	private JLabel lblDisplayLongestWords;
	private JTextField jtUserResponse;
	private JButton jbSubmitAnswer;
	private JButton jbRequestLongestWords;
	private JButton jbDone;

	private ArrayList<String> bigWords;
	private ArrayList<String> allSentences;
	


	//default constructor
	public TheJPanel(){

		setLayout(new FlowLayout());
		//The initial label text should say "Tell me what is on your mind today in 1 sentence.”
		lblQuestions = new JLabel("Tell me what is on your mind today in one sentence.");
		//DONT FORGET TO ADD() IT TO THE PANEL
		add(lblQuestions);

		
		//create a new textfield for the user's response and add it the panel
		JPanel tfPanel = new JPanel();
		jtUserResponse = new JTextField("answer goes here", 30);
		jtUserResponse.setSize(100, 100);
		jtUserResponse.setBackground(Color.white);
		tfPanel.setLayout(new FlowLayout(1, 1, 1));
		tfPanel.add(jtUserResponse);
		add(tfPanel);


		
		ImageIcon img = new ImageIcon("yello_cat.png");
		//create buttons and add it to the panel
		
		jbSubmitAnswer = new JButton(" ENTER ", img);
		jbSubmitAnswer.setBackground(Color.yellow);
		jbSubmitAnswer.setToolTipText("This button stores your sentences");
		
		jbDone = new JButton(" DONE ");
		jbDone.setBackground(Color.cyan);
		jbDone.setToolTipText("This button tells you the file of your sentences and displays it in a text area");
		
		jbRequestLongestWords = new JButton(" REQUEST LONG WORDS ");
		jbRequestLongestWords.setBackground(Color.red);
		jbRequestLongestWords.setToolTipText("This button takes all of the long words from your sentences and displays it");



		//add the buttons to action listener
		jbSubmitAnswer.addActionListener(this);
		jbDone.addActionListener(this);
		jbRequestLongestWords.addActionListener(this);


		//adding buttons to panel
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(3, 1));
		btnPanel.add(jbSubmitAnswer);
		btnPanel.add(jbDone);
		btnPanel.add(jbRequestLongestWords);
		

		add(btnPanel);

		lblDisplay = new JLabel();
		add(lblDisplay);

		lblDisplayLongestWords = new JLabel();
		add(lblDisplayLongestWords);
		

		//set up array list
		bigWords = new ArrayList<String>();
		allSentences = new ArrayList<String>();


	}

	//this method gets the textfield into a string
	public String getStringFromTextField(JTextField jtf) throws Exception{
		String s = "";
		try{
			if(jtf != null){
				s = jtf.getText();
			}
			else{
				throw new Exception("No NULL input!!");
			}
		}
		catch(Exception e){
			s = e.getMessage();
		}

		return s;
	}
	//this method takes in the sentence and puts it in an array
	//it separates the elements when it sees a space
	public String[] convertSentToArrayOfWords(String s){
		String [] arr = s.split(" ");

		return arr;
	}
	//this method takes the array filled with the separated sentence
	//and returns the longest word
	public String getLongestWordFromTextField(String [] arr){
		String longestWord = "";
		int [] count= new int[arr.length];
		//for each element it stores the length of each element
		for(int i = 0; i < count.length; i++){
			count[i] = arr[i].length();			
		}
		//sorts the array from smallest to largest numbers
		Arrays.sort(count);
		int longestWordLength = count[count.length - 1];
		//finds the word with the longest number of characters and stores it
		for(int a = 0 ; a < arr.length; a++){
			if(arr[a].length() == longestWordLength){
				longestWord += arr[a];
			}
		}
		return longestWord;

	}
	/*this method takes in the the longest and
	 * displays a question regarding the length of the word
	 */
	public String questionsDependingOnWordLength(String bigWord) throws Exception{
		String s = "";
		String sentence = "";
		try{
			if(bigWord.length() < 3){//if less than 3
				s = "Is there something else you would like to discuss?";

			}
			else if(bigWord.length() == 3){
				s = "Why do you feel \"" + bigWord + "\" is important?";
			}
			else if(bigWord.length() == 4){
				s = "OK tell more about \"" + bigWord + "\"";
			}
			else if(bigWord.length() == 5){ 
				s = "How does \"" + bigWord + "\" affect you?";
			}
			else if(bigWord.length() > 5){//if greater than 5
				s = "We seem to be making great progress with \""+ bigWord + "\"";
			}
			else{
				throw new Exception("Invalid input!");
			}
		}
		catch(Exception e){
			s = e.getMessage();
		}

		return s;
	}
	//this method takes in an array of words type ArrayList and iterates
	//through it to store it in a string
	public String iterateThroughArrayList_Words(ArrayList<String> arr){
		String p = "";
		Iterator itr = arr.iterator();
		while(itr.hasNext()){
			p += (itr.next() + ", ");
		}
		return p;
	}
	//this method takes in an array of sentences type ArrayList and 
	//iterates through it and stores it in a string
	public String iterateThroughArrayList_SentencesInFile(ArrayList<String> arr){
		String p = "";
		Iterator itr = arr.iterator();
		while(itr.hasNext()){
			p += (itr.next() + " /// ");
		}
		return p;
	}
	//this method takes in an array of sentences type ArrayList and 
		//iterates through it and stores it in a string
		public String iterateThroughArrayList_Sentences(ArrayList<String> arr){
			String p = "";
			Iterator itr = arr.iterator();
			while(itr.hasNext()){
				p += (itr.next() + " \n");
			}
			return p;
		}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		String fileName = "containsSentencesFile.txt";
		TextFileHandler handlerForSentenceFile = new TextFileHandler();
		handlerForSentenceFile.createNewFile(fileName);
		
		JTextArea jta = new JTextArea();
		JScrollPane scroll = new JScrollPane();
		
		String click = e.getActionCommand(); 
		//When the user submits their sentence your program 
		//should find the longest word in the sentence.

		try {
			String text = "";
			//these are variables for the actionPerformed()method
			String sentence = getStringFromTextField(jtUserResponse);
			String longestWord = "";//stores the longest word in the sentence

			switch(click){
			case " ENTER ":
				//save the sentence in a file 
				//add the text to the arraylist for sentences
				allSentences.add(sentence);

				//put all of the longest words in an array
				longestWord = getLongestWordFromTextField(convertSentToArrayOfWords(sentence));
				//save the longest word in the arraylist
				bigWords.add(longestWord);

				if(text.equalsIgnoreCase("end")){
					lblQuestions.setText("Okay, goodbye. Have a nice day!");
				}
				else{
					lblQuestions.setText(questionsDependingOnWordLength(longestWord));
				}
				break;
			case " DONE ":
				String sent = iterateThroughArrayList_SentencesInFile(allSentences);

				//go to file and a append the sentence its respective file
				
				handlerForSentenceFile.appendToFile(fileName, sent);
				
				//read file		
				String sent2 = iterateThroughArrayList_Sentences(allSentences);

				jta = new JTextArea(10, 30);
				jta.append(sent2);
				jta.setBounds(2, 4, 10, 10);
				jta.setEditable(false);
				add(jta);
				
				//adding scrollbar
				scroll = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				add(scroll);

				lblDisplay.setText("Name of file containing all of your sentences: \"" + fileName + "\"");
				break;
			case " REQUEST LONG WORDS ":
				
				lblDisplayLongestWords.setText("Longest words: " + iterateThroughArrayList_Words(bigWords));

				break;
			default:
				lblDisplay.setText("This GUI is driving me nuts!!!");
				break;
			}
		} catch (Exception exc) {
			lblDisplay.setText("You have a problem: " + exc.getMessage());
		}

	}

	
}
