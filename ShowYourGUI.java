package midterm_project;


public class ShowYourGUI {

	public static void main(String[] args){		
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				TheJFrame myGUI = new TheJFrame();
			}
		});
	}
}
