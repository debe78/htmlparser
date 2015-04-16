package org.neo4art.htmlparser.custom;

import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.neo4art.htmlparser.IHtmlLetterParser;
import org.neo4art.htmlparser.bean.Letter;
import org.neo4art.htmlparser.exception.HtmlLetterParserException;


public class VanGoghLetterHtmlParser  {
	
	private IHtmlLetterParser htmlLetterParser;

	public Letter getLetter(URL url) throws HtmlLetterParserException{
		Letter letter = new Letter();
		String htmlPageByUrl = htmlLetterParser.getHtmlPageByUrl(url);
		String patternEXP = "(1r:1)+([\\w\\s\\W]*)";
		Pattern pattern = Pattern.compile(patternEXP);
		Matcher matcher = pattern.matcher(htmlPageByUrl);
		
		while (matcher.find()) {
			letter.setText(matcher.group(2));
		}

		
		//FROM 
		String patternEXPFrom = "(From:)+(\\s[a-zA-Z\\s.é]*)+(\\sTo)";
		Pattern patternFrom = Pattern.compile(patternEXPFrom);
		Matcher matcherFrom = patternFrom.matcher(htmlPageByUrl);
		
		while (matcherFrom.find()) {
			letter.setFrom(matcherFrom.group(2).replaceAll("^\\s+|\\s+$|\\s*(\n)\\s*|(\\s)\\s*", "$1$2"));
		}
		
		//To 
		String patternEXPTo = "(To:)+(\\s[a-zA-Z\\s.-é]*)+(\\sDate)";
		Pattern patternTo = Pattern.compile(patternEXPTo);
		Matcher matcherTo = patternTo.matcher(htmlPageByUrl);
		
		while (matcherTo.find()) {
			letter.setTo(matcherTo.group(2).replaceAll("^\\s+|\\s+$|\\s*(\n)\\s*|(\\s)\\s*", "$1$2"));
		}
		
		//Date 
		String patternEXPDate = "(Date:)+(\\s[a-zA-Z?Îé/,0-9-.-]*)+(\\s<)";
		Pattern patternDate = Pattern.compile(patternEXPDate);
		Matcher matcherDate = patternDate.matcher(htmlPageByUrl);
		String date = "";
		
//		System.out.println(htmlPageByUrl);
//		System.out.println("\n--------------------\n");
		
		
		if (matcherDate.find()) {
		
			date = matcherDate.group(0);
			
//			System.out.println(date);
			
			date = date.replaceAll("^\\s+|\\s+$|\\s*(\n)\\s*|(\\s)\\s*", "$1$2");
			date = date.replace("Date: ", "");
			date = date.replace("<", "");
			date = date.replace("\n","");
		}
		
//		System.out.println("date: "+date);
		
		String[] vettDate = date.split(",");
		String place = vettDate[0];
		letter.setPlace(place);
		String dateLetter = date.substring(place.length()+1,date.length());
		letter.setDate(dateLetter.replaceFirst(" ", ""));
		
		
		//PULISCO IL TESTO

		String text = letter.getText().replaceAll("\\|\\s+[\\w\\W]*", "");
		text = text.replaceAll("<[^>]*>+[0-9a-z:]*", "");
		letter.setText(text);
		
		String title = this.htmlLetterParser.getMetadata().get("title");
		String[] titleGenerale = title.split(":");
		String titleGenerale1 = titleGenerale[1];
		letter.setTitle(titleGenerale1);
		
		letter.setUrl(""+url);
		
		letter.setText(letter.getText().replace(",", " , "));
		letter.setText(letter.getText().replace(".", " . "));
		letter.setText(letter.getText().replace(";", " ; "));
		letter.setText(letter.getText().replaceAll("(\\[sketch\\s\\w\\])", ""));
		letter.setText(letter.getText().replaceAll("^\\s+|\\s+$|\\s*(\n)\\s*|(\\s)\\s*", "$1$2"));
		
		return letter;
	}
	
	public void setHtmlLetterParser(IHtmlLetterParser htmlLetterParser) {
		this.htmlLetterParser = htmlLetterParser;
	}
	
}
