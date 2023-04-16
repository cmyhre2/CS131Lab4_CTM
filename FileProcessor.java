import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
public class FileProcessor {

	private String fileName;
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	private int stringLength;
	public int getStringLength() {
		return stringLength;
	}

	public void setStringLength(int stringLength) {
		if(stringLength<5)
			this.stringLength = 5;
		else
			this.stringLength = stringLength;
	}

	private ArrayList<String> stringList ;
	private Scanner input;
	
	public FileProcessor(String fileName, int stringLength) {
		this.fileName = fileName;
		this.stringLength = stringLength;
	}//end empty-argument constructor
	
	public int getArrayListSize() {
		return stringList.size();
	}//end getArrayListSize
	
	public void processFile(){
		FileScanner : try {
			input = new Scanner(new File(fileName));
			while(input.hasNextLine()) {
				StringTooLongException exception = new StringTooLongException("String is too long!");
				try {
					String string = input.nextLine();
					if(string.length()<=getStringLength())
					System.out.println(string);
				else
					throw exception;
					}//end try block for string length checker
				catch (StringTooLongException e) {
					System.out.println(exception);
				}//end catch block for string length checker
			}//end while loop
			input.close();
		}//end try block for File
		catch(FileNotFoundException e) {
			System.out.println("File not found!");
			break FileScanner;
		}//end catch block for File
	}//end processFile
}//end class