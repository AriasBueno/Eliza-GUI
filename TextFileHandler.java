package midterm_project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class TextFileHandler extends TheJPanel implements TextFileIOable{

	@Override
	public void createNewFile(String fileName) {
		PrintWriter outStream = null;
		try{
			outStream = new PrintWriter(fileName);//creates a new empty file
		}
		catch(FileNotFoundException e){
			System.err.println("Could not create file " + fileName + " MESSAGE: " + e.getMessage());
		}
		finally{
			if(outStream != null){
				outStream.close();//this way it doesn't waste any bits
			}
			System.out.println("end of create new file");
		}
		System.out.println("SUCCESS creating new file");
	}
	//this method inputs strings from an array list to a file
	public void appendToFile2(String fileName, ArrayList<String> arr){
		try{
			FileWriter fw = new FileWriter(fileName);
			Writer output = new BufferedWriter(fw);
			for(int i = 0; i < arr.size(); i++){
				((PrintWriter) output).println(arr.get(i).toString() + "////");
			}
			output.close();
		}
		catch(Exception e){
			System.err.println("I cannot append to the file.");
		}
		
		
	}
	//this method takes in an array and appends each element to a new line in a file
	public void appentToFile3(String fileName, ArrayList<String> arr){
		PrintWriter outputStream = null;
		try{
			for(int i = 0; i < arr.size(); i++){
				String line = arr.get(i);
				outputStream.println(line);
			}
		}
		catch(Exception e){
			System.err.println("I cannot append to the file.");

		}
		finally{
			outputStream.close();
			System.out.println("SUCCESSFULLY appended lines to file!");
		}
	}
	@Override
	public void writeToNewFile(String fileName, String text){
		PrintWriter outStream = null;
		try{
			outStream = new PrintWriter(fileName);//creating a new empty file
			outStream.println(text);//write the text to the file
		}
		catch(FileNotFoundException e){
			System.err.println("Could not write to new file " + fileName + " MESSAGE: " + e.getMessage());
		}
		finally{
			if(outStream != null){
				outStream.close();//this way it doesn't waste any bits
			}
			System.out.println("end of write to new file");
		}
		System.out.println("SUCCESS writing to new file");
	}

	@Override
	public void appendToFile(String fileName, String text) {
		PrintWriter outStream = null;
		try{
			outStream = new PrintWriter(new FileOutputStream(fileName, true) );//true to append to end of file
			outStream.println(text);		

		}
		catch(FileNotFoundException e){
			System.err.println("Could not append to new file " + fileName + " MESSAGE: " + e.getMessage());
		}
		finally{
			if(outStream != null){
				outStream.close();//this way it doesn't waste any bits
			}
			System.out.println("end of append to new file");
		}
		System.out.println("SUCCESS appending to new file");
	}

	
	@Override
	public boolean deleteFile(String fileName) {
		File fileObj = new File(fileName);
		if(fileObj.exists()){
			//System.out.println("Found it!" + fileObj.getAbsolutePath());
			if(fileObj.delete()){
				System.out.println("DELETED!!!! " + fileObj.getName());
				return true;
			}
		}
		System.out.println("Not found!" + fileObj.getAbsolutePath());
		return false;
	}

	@Override
	public boolean copyFile(String fileName) {
		Scanner inStream = null;
		PrintWriter outStream = null;
		String fileLine = "";//somewhere to store the line from the file
		String fileNameCopy = "copy_" + fileName;//need an output filename
		try{
			inStream = new Scanner( new File(fileName));//connect to input file
			outStream = new PrintWriter(new FileOutputStream(fileName, false));//should be false because you're not appending anything(your only opening it once so it should be a new file)
			while(inStream.hasNextLine()){//read from input file
				fileLine = inStream.nextLine();
				outStream.println(fileLine);//write that line to the output file
			}
		}
		catch(FileNotFoundException e){
			System.err.println("Could not copy file " + fileName);
			return false;
		}
		finally{
			if(inStream  != null){
				inStream.close();
			}
			if(outStream != null){
				outStream.close();
			}
			System.out.println("DONE with copying file");
		}
		return true;
	}

	@Override
	public boolean copyFile(String fileName1, String fileName2) {
		Scanner inStream = null;
		PrintWriter outStream = null;
		String fileLine = "";//somewhere to store the line from the file
		//String fileNameCopy = "copy_" + fileName;//need an output filename
		try{
			inStream = new Scanner( new File(fileName1));//connect to input file
			outStream = new PrintWriter(new FileOutputStream(fileName2, false));//should be false because you're not appending anything(your only opening it once so it should be a new file)
			while(inStream.hasNextLine()){//read from input file
				fileLine = inStream.nextLine();
				outStream.println(fileLine);//write that line to the output file
			}
		}
		catch(FileNotFoundException e){
			System.err.println("Could not copy file " + fileName1);
			return false;
		}
		finally{
			if(inStream  != null){
				inStream.close();
			}
			if(outStream != null){
				outStream.close();
			}
			System.out.println("DONE with copying file");
		}
		return true;
	}

	@Override
	public boolean findAndReplaceFileContent(String fileName, String txtOrig,
			String txtReplace) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String readFile(String fileName) {
		Scanner inStream = null;
		String fileContents = "";//somewhere to store the file contents
		try{
			inStream = new Scanner( new File(fileName));
			while(inStream.hasNextLine()){
				fileContents += inStream.nextLine() + ", ";
			}
		}
		catch(FileNotFoundException e){
			System.err.println("Could no read from file " + fileName + " MESSAGE: " + e.getMessage());

		}
		finally{
			if(inStream != null){
				inStream.close();
			}
		}
		System.out.println("DONE reading\n");
		return fileContents;
	}

	@Override
	public String readDelimitedFile(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
