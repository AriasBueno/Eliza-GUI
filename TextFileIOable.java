package midterm_project;

public interface TextFileIOable {

	//specify an abstract method
	public void createNewFile(String fileName);
	public void writeToNewFile(String fileName, String text);
	public void appendToFile(String fileName, String text);
	public boolean deleteFile(String fileName);
	public boolean copyFile(String fileName);//make a copy of a file
	public boolean copyFile(String fileName1, String fileName2);//overloaded
	public boolean findAndReplaceFileContent(String fileName, String txtOrig, String txtReplace);
	public String readFile(String fileName);
	public String readDelimitedFile(String fileName);
}
