package MainPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/// Creates, reads and writes the text files
public class MyTextFileIO
{
	// used for writing to file
	FileOutputStream fileOut = null;
	PrintWriter write = null;
	// used for reading from file
	FileInputStream fileIn = null;
	Scanner read = null;

	public void writeToFile(String fileName, String stringToWrite) throws FileNotFoundException
	{
		fileOut = new FileOutputStream(fileName);
		write = new PrintWriter(fileOut);

		write.println(stringToWrite);
		write.close();
	}

	public void writeToFile(String fileName, String[] stringArrToWrite) throws FileNotFoundException
	{
		fileOut = new FileOutputStream(fileName);
		write = new PrintWriter(fileOut);

		for (int i = 0; i < stringArrToWrite.length; i++)
			write.println(stringArrToWrite[i]);

		write.close();
	}

	public void appendToFile(String fileName, String stringToAppend) throws FileNotFoundException
	{
		// NOTE: "true" serves as an indicator that this is an existing file
		// should not be re-created but appended to
		fileOut = new FileOutputStream(fileName, true);
		write = new PrintWriter(fileOut);

		write.println(stringToAppend);
		write.close();
	}

	public void appendToFile(String fileName, String[] stringArrToAppend) throws FileNotFoundException
	{
		// NOTE: "true" serves as an indicator that this is an existing file
		// should not be re-created but appended to
		fileOut = new FileOutputStream(fileName, true);
		write = new PrintWriter(fileOut);

		for (int i = 0; i < stringArrToAppend.length; i++)
			write.println(stringArrToAppend[i]);

		write.close();
	}

	public String readingStringFromFile(String fileName) throws FileNotFoundException
	{
		fileIn = new FileInputStream(fileName);
		read = new Scanner(fileIn);
		String temp = read.nextLine();
		read.close();

		return temp;
	}

	public String[] readArrayFromFile(String fileName) throws FileNotFoundException
	{
		ArrayList<String> tempArrList = new ArrayList<String>();
		String[] tempArr = null;

		fileIn = new FileInputStream(fileName);
		read = new Scanner(fileIn);

		while (read.hasNextLine())
			tempArrList.add(read.nextLine());

		tempArr = new String[tempArrList.size()];

		// takes and array and casts it to the type of array give as argument
		// automatically
		tempArr = tempArrList.toArray(tempArr);
		read.close();

		return tempArr;
	}

}
