/**
 * 
 */
package org.neo4art.htmlparser.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.neo4art.htmlparser.HtmlLetterParser;
import org.neo4art.htmlparser.IHtmlLetterParser;
import org.neo4art.htmlparser.bean.Letter;
import org.neo4art.htmlparser.custom.VanGoghLetterHtmlParser;
import org.neo4art.htmlparser.exception.LetterParserException;

/**
 * @author Enrico
 *
 */
public class LetterServiceTest {

	@Test
	public void testSaveNumericUrlVanGoghLetters(){
		
		ILetterService letterService = new LetterService();
		VanGoghLetterHtmlParser vanGoghLetterHtmlParser = new VanGoghLetterHtmlParser();
		
		try{
		
		  FileUtils.cleanDirectory(Paths.get("/home/larus/Progetti/Git/htmlparser/htmlparser/src/main/resources/vangoghletters").toFile());
		}
		catch(IOException e){
			
		  Assert.fail(e.getMessage());
		}
		
		
        for(int i=0; i<902; i++){
			
			String numeroLettera="";
			numeroLettera = StringUtils.leftPad(numeroLettera,3-Integer.toString(i+1).length()  , "0");
			numeroLettera+=""+(i+1);
		
			try {
				
				URL url = new URL("http://vangoghletters.org/vg/letters/let"+numeroLettera+"/letter.html");
			    saveLetterOnFile(letterService, vanGoghLetterHtmlParser, numeroLettera,url);
				 
			} catch (MalformedURLException e) {
				Assert.fail(e.getMessage());
			}
        }
		
		
		@SuppressWarnings("rawtypes")
		Collection listFiles = FileUtils.listFiles(Paths.get("/home/larus/Progetti/Git/htmlparser/htmlparser/src/main/resources/vangoghletters").toFile(), null, false);
		Assert.assertTrue(listFiles.size() > 0);
		Assert.assertEquals(902, listFiles.size());
	}
	
	
	@Test
	public void testSaveNonNumericUrlVanGoghLetters(){
		
		ILetterService letterService = new LetterService();
		VanGoghLetterHtmlParser vanGoghLetterHtmlParser = new VanGoghLetterHtmlParser();
		
		
			try {
				
				URL url = new URL("http://vangoghletters.org/vg/letters/let001a/letter.html");
			    saveLetterOnFile(letterService, vanGoghLetterHtmlParser, "001a",url);
			    
			    for(int i=0; i<25; i++){
					
					String numeroLettera="";
					numeroLettera = StringUtils.leftPad(numeroLettera,2-Integer.toString(i+1).length()  , "0");
					numeroLettera+=""+(i+1);
			   
					 URL urlM = new URL("http://vangoghletters.org/vg/letters/RM"+numeroLettera+"/letter.html");
					 saveLetterOnFile(letterService, vanGoghLetterHtmlParser, "RM"+numeroLettera,urlM);
			    
			    }
			    
				 
			} catch (MalformedURLException e) {
				Assert.fail(e.getMessage());
			}
        
		
		
		@SuppressWarnings("rawtypes")
		Collection listFiles = FileUtils.listFiles(Paths.get("/home/larus/Progetti/Git/htmlparser/htmlparser/src/main/resources/vangoghletters").toFile(), null, false);
		Assert.assertTrue(listFiles.size() > 0);
		Assert.assertEquals(928, listFiles.size());
	}

	@Test
	public void testLetterList(){
		
		ILetterService letterService = new LetterService();
		
		try {
			
		  List<Letter> lettersFromPath = letterService.getLettersFromPath(Paths.get("/home/larus/Progetti/Git/htmlparser/htmlparser/src/main/resources/vangoghletters"));
		  Assert.assertNotNull(lettersFromPath);;
		  Assert.assertEquals(928, lettersFromPath.size());

		  for (Letter letter : lettersFromPath) {
			
//				System.out.println("Location: "+letter.getPlace()+"\n");
//				System.out.println("Date: "+letter.getDate()+"\n");
//				System.out.println("From: "+letter.getFrom()+"\n");
//				System.out.println("To: "+letter.getTo()+"\n");
//				System.out.println("Url: "+letter.getUrl()+"\n");
//				System.out.println("Testo: \n"+letter.getText()+"\n");
//				System.out.println("----------------------------------------------------\n");
			  
			  
			  if(letter.getDate().trim().length()==0){
				  
				 System.out.println("Lettera senza data: "+letter.getUrl()); 
			  }
			  if(letter.getTo().trim().length()==0){
				  
					 System.out.println("Lettera senza To: "+letter.getUrl()); 
			  }
			  if(letter.getFrom().trim().length()==0){
				  
					 System.out.println("Lettera senza From: "+letter.getUrl()); 
			  }
			  if(letter.getPlace().trim().length()==0){
				  
					 System.out.println("Lettera senza Luogo: "+letter.getUrl()); 
			  }
			  
			  
		}
		  
		  
		} catch (LetterParserException e) {
			Assert.fail(e.getMessage());
		}
		
	}
	
	
	/**
	 * @param letterService
	 * @param vanGoghLetterHtmlParser
	 * @param numeroLettera
	 */
	private void saveLetterOnFile(ILetterService letterService,
			VanGoghLetterHtmlParser vanGoghLetterHtmlParser,
			String numeroLettera,URL url) {
		try {
			
			IHtmlLetterParser htmlParser = new HtmlLetterParser();
			vanGoghLetterHtmlParser.setHtmlLetterParser(htmlParser); 
			  
			
			Letter letter = vanGoghLetterHtmlParser.getLetter(url);
			
			Path path = Paths.get("/home/larus/Progetti/Git/htmlparser/htmlparser/src/main/resources/vangoghletters/let"+numeroLettera+".txt");
			letterService.saveLetterFromUrl(letter, path);
			
	  	  } catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		  }
	}
	
	
}