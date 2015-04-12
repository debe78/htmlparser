/**
 * 
 */
package org.neo4art.htmlparser.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.neo4art.htmlparser.bean.Letter;
import org.neo4art.htmlparser.exception.LetterParserException;

/**
 * @author Enrico
 *
 */
public class LetterService implements ILetterService{

	/**
	 * Method that save a letter into the giving path.
	 * 
	 * @param Letter - the letter to save. 
	 * @param Path - the path where save the letter
	 */
	public void saveLetterFromUrl(Letter letter, Path path) {
		
		try
		 {
			 PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(path.toFile(), true)));
			 printWriter.print("Title|"+letter.getTitle());
			 printWriter.print("\nLocation|"+letter.getPlace());
			 printWriter.print("\nDate|"+letter.getDate());
			 printWriter.print("\nTo|"+letter.getTo());
			 printWriter.print("\nFrom|"+letter.getFrom());
			 printWriter.print("\nUrl letter|"+letter.getUrl());
			 printWriter.print("\nLetter|"+letter.getText());
			 printWriter.close();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
		
		
	}

	 /**
	  * Method that returns the list of the letters stored in the path.
	  * 
	  * @param path - the path  where there are files.
	  * @return - the list of the letters.
	  */
	@SuppressWarnings("unchecked")
	public List<Letter> getLettersFromPath(Path path) throws LetterParserException{
		
		List<Letter> letterList = new ArrayList<Letter>();
		
		//Ottenere la lista dei file
		Collection<File> listFiles = FileUtils.listFiles(path.toFile(), null, false);
		
		//Per ogni file leggere il conenuto
		elaboraFiles(listFiles,letterList);
		
		return letterList;
	}

	/**
	 * @param listFiles
	 * @throws LetterParserException
	 */
	private void elaboraFiles(Collection<File> listFiles,List<Letter> letterList)
			throws LetterParserException {
		
		for (File file : listFiles) {
			
			Letter letter = elaboraFile(file);
			letterList.add(letter);
		}
	}

	/**
	 * @param file
	 * @throws LetterParserException
	 */
	private Letter elaboraFile(File file) throws LetterParserException {
		
		Letter letter = new Letter();
		
		try {
			
			@SuppressWarnings("unchecked")
			List<String> listContentFile = FileUtils.readLines(file);
			
			//Title
			letter.setTitle(parseLetterContent(listContentFile,0));
			//Location
			letter.setPlace(parseLetterContent(listContentFile,1));
			//Date
			letter.setDate(parseLetterContent(listContentFile,2));
			//TO
			letter.setTo(parseLetterContent(listContentFile,3));
			//From
			letter.setFrom(parseLetterContent(listContentFile,4));
			//Url
			letter.setUrl(parseLetterContent(listContentFile,5));
			//Letter
            letter.setText(parseLetterTextContent(listContentFile,6));
		
		} catch (IOException e) {
			
			throw new LetterParserException(e.getMessage());
		}
		
		return letter;
	}

	/**
	 * @param listContentFile
	 * @param i
	 * @return
	 */
	private String parseLetterTextContent(List<String> listContentFile, int indice) {
		
		String text="";
		
		for (int i = indice; i < listContentFile.size(); i++) {
			
			text+=listContentFile.get(i);
		}
		
		return text.replace("Letter|", "");
	}

	/**
	 * @param listContentFile
	 * @return
	 */
	private String parseLetterContent(List<String> listContentFile,int indice) {
		
		String result="";
		
		String elementRow = listContentFile.get(indice);
		String[] element = StringUtils.split(elementRow, "|");
		
		if(element.length == 2){
			
			result = element[1];	
		}
		
		return result;
	}

}
