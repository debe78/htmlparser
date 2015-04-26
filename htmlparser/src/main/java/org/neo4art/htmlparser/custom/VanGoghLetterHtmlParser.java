package org.neo4art.htmlparser.custom;

import java.net.URL;
import java.util.ArrayList;
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
		String patternEXPFrom = "(From:)+(\\s[a-zA-Z\\s.,éè-]*)+(\\sTo)";
		Pattern patternFrom = Pattern.compile(patternEXPFrom);
		Matcher matcherFrom = patternFrom.matcher(htmlPageByUrl);
		
		while (matcherFrom.find()) {
			letter.setFrom(matcherFrom.group(2).replaceAll("^\\s+|\\s+$|\\s*(\n)\\s*|(\\s)\\s*", "$1$2"));
		}		
		
		//LINK IMAGE LETTER
		String patternEXPImage = "<img src=\"/vg/facsimiles/+([A-z0-9.-]*)";
		Pattern patternImage = Pattern.compile(patternEXPImage);
		Matcher matcherImage = patternImage.matcher(htmlPageByUrl);
		//int i = 0;
		ArrayList<String> arrayListLink = new ArrayList<String>();
		while (matcherImage.find()) {
			String link =matcherImage.group(1);
			link = link.replace(".jpg", ".png");
			link = link.replace("t", "f");
			link = "http://vangoghletters.org/vg/facsimiles/"+link;
			arrayListLink.add(link);
		}
		letter.setLink(arrayListLink);
		
		//To 
		String patternEXPTo = "(To:\\s)+([A-Za-z\\s-éèä.]*)+(Date:)";
		Pattern patternTo = Pattern.compile(patternEXPTo);
		Matcher matcherTo = patternTo.matcher(htmlPageByUrl);
		
		String to = "";
		while (matcherTo.find()) {
			to = matcherTo.group(0).replaceAll("^\\s+|\\s+$|\\s*(\n)\\s*|(\\s)\\s*", "$1$2");
		}
		to = to.replaceAll("To: ", "");
		to = to.replaceAll("Date:", "");
		to = to.replaceAll("\n", "");
		letter.setTo(to);
		
		//Museum
		String patternEXPMuseum = "(Location:\\s)+([a-zA-Z,.,0-9/\\(\\)’\\- ]*)";
		Pattern patternMuseum = Pattern.compile(patternEXPMuseum);
		Matcher matcherMuseum = patternMuseum.matcher(htmlPageByUrl);
		
		if (matcherMuseum.find()) {
			letter.setMuseum(matcherMuseum.group(0));
		}
		String museum = letter.getMuseum().replace("Date:", "");
		museum = museum.replace("Location: ", "");
		museum = museum.replace("\n", "");
		
		//Rimuovere dal testo: Città,Museo,Inventario il primo e il terzo e salvare l'inventario
		//a parte
		int indexOfVirgola = museum.indexOf(",");
		if(indexOfVirgola > 0){
			museum = museum.substring(indexOfVirgola+1, museum.length());	
		}
		
		int indexOfInventory = museum.indexOf("inv");
		if(indexOfInventory > 0){
			
			letter.setInventory(museum.substring(indexOfInventory, museum.length()));
			museum = museum.substring(0,indexOfInventory);	
		}
		
		int indexOfInventoryUpper = museum.indexOf("Inv");
		if(indexOfInventoryUpper > 0){
			
			letter.setInventory(museum.substring(indexOfInventoryUpper, museum.length()));
			museum = museum.substring(0,indexOfInventoryUpper);	
		}
		
		letter.setMuseum(museum.replace(",", ""));

		//Date 
		String patternEXPDate = "(Date:)+(\\s[a-zA-Z?Îé/,0-9-.-]*)+(\\s<)";
		Pattern patternDate = Pattern.compile(patternEXPDate);
		Matcher matcherDate = patternDate.matcher(htmlPageByUrl);
		String date = "";
		
		if (matcherDate.find()) {
		
			date = matcherDate.group(0);
			date = date.replaceAll("^\\s+|\\s+$|\\s*(\n)\\s*|(\\s)\\s*", "$1$2");
			date = date.replace("Date: ", "");
			date = date.replace("<", "");
			date = date.replace("\n","");
		}
		
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
		
		letter.setText(letter.getText().replace("\"", "‘‘"));
		letter.setText(letter.getText().replace("’", "‘"));
		letter.setText(letter.getText().replace("&amp;", "&"));
		letter.setText(letter.getText().replaceAll("(\\[sketch\\s\\w\\])", ""));
		letter.setText(letter.getText().replaceAll("^\\s+|\\s+$|\\s*(\n)\\s*|(\\s)\\s*", "$1$2"));
		
		return letter;
	}
	
	public void setHtmlLetterParser(IHtmlLetterParser htmlLetterParser) {
		this.htmlLetterParser = htmlLetterParser;
	}
	
}
