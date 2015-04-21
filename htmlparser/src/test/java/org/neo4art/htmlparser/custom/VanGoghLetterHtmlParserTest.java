package org.neo4art.htmlparser.custom;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;
import org.neo4art.htmlparser.HtmlLetterParser;
import org.neo4art.htmlparser.IHtmlLetterParser;
import org.neo4art.htmlparser.bean.Letter;
import org.neo4art.htmlparser.exception.HtmlLetterParserException;

public class VanGoghLetterHtmlParserTest {

	@Test
	public void theHague29September1872HtmlParserTest()
			throws MalformedURLException, HtmlLetterParserException {

		String testToValidate = "The Hague, 29 September 1872.\n"+
                                "My dear Theo,\n"+
                                "Thanks for your letter, I was glad to hear that you got back safely. I missed you the first few days, and it was strange for me not to find you when I came home in the afternoon.\n"+
                                "We spent some pleasant days together, and actually did go for some walks and see a thing or two whenever we had the chance.\n"+
                                "What terrible weather, you must feel anxious on your walks to Oisterwijk. Yesterday there were trotting races on the occasion of the exhibition, but the illumination and fireworks were postponed because of the bad weather, so it’s just as well you didn’t stay to see them. Regards from the Haanebeeks and the Rooses. Ever,\n"+
                                "Your loving\n"+
                                "Vincent";

		URL url = new URL(
				"http://vangoghletters.org/vg/letters/let001/letter.html");
		VanGoghLetterHtmlParser vanGoghLetterParser = new VanGoghLetterHtmlParser();
		IHtmlLetterParser htmlParser = new HtmlLetterParser();

		vanGoghLetterParser.setHtmlLetterParser(htmlParser);
		Letter letter = vanGoghLetterParser.getLetter(url);

		Assert.assertNotNull(letter);
		Assert.assertNotNull(letter.getText());
		Assert.assertNotNull(letter.getFrom());
		Assert.assertTrue(letter.getText().trim().length() > 0);

		System.out.println(letter.getText());
		System.out.println("titolo: "+htmlParser.getMetadata().get("title"));
		
		Assert.assertEquals(testToValidate, letter.getText());
	}
	
	@Test
	public void getLetter366Test()
			throws MalformedURLException, HtmlLetterParserException {

		URL url = new URL(
				"http://vangoghletters.org/vg/letters/let366/letter.html");
		VanGoghLetterHtmlParser vanGoghLetterParser = new VanGoghLetterHtmlParser();
		IHtmlLetterParser htmlParser = new HtmlLetterParser();

		vanGoghLetterParser.setHtmlLetterParser(htmlParser);
		Letter letter = vanGoghLetterParser.getLetter(url);

		Assert.assertNotNull(letter);
		Assert.assertNotNull(letter.getText());
		Assert.assertNotNull(letter.getFrom());
		Assert.assertTrue(letter.getText().trim().length() > 0);

		System.out.println("Titolo: "+letter.getTitle());
		System.out.println("To: "+letter.getTo());
		System.out.println("From: "+letter.getFrom());
		System.out.println("Date: "+letter.getDate());
		System.out.println("Place: "+letter.getPlace());
		System.out.println("Location: "+letter.getMuseum());
		
		Assert.assertEquals("Theo van Gogh", letter.getTo());
		Assert.assertEquals("Vincent van Gogh", letter.getFrom());
		Assert.assertEquals("on or about Tuesday, 24 July 1883", letter.getDate());
		Assert.assertEquals("The Hague", letter.getPlace());

		
	}
	
	@Test
	public void getLetter3Test()
			throws MalformedURLException, HtmlLetterParserException {

		URL url = new URL(
				"http://vangoghletters.org/vg/letters/let003/letter.html");
		VanGoghLetterHtmlParser vanGoghLetterParser = new VanGoghLetterHtmlParser();
		IHtmlLetterParser htmlParser = new HtmlLetterParser();

		vanGoghLetterParser.setHtmlLetterParser(htmlParser);
		Letter letter = vanGoghLetterParser.getLetter(url);

		Assert.assertNotNull(letter);
		Assert.assertNotNull(letter.getText());
		Assert.assertNotNull(letter.getFrom());
		Assert.assertTrue(letter.getText().trim().length() > 0);

		System.out.println("Titolo: "+letter.getTitle());
		System.out.println("To: "+letter.getTo());
		System.out.println("From: "+letter.getFrom());
		System.out.println("Date: "+letter.getDate());
		System.out.println("Place: "+letter.getPlace());
		System.out.println("Location: "+letter.getMuseum());
		
		Assert.assertEquals("Theo van Gogh", letter.getTo());
		Assert.assertEquals("Vincent van Gogh", letter.getFrom());
		Assert.assertEquals("mid-January 1873", letter.getDate());
		Assert.assertEquals("The Hague", letter.getPlace());
		Assert.assertEquals("Amsterdam, Van Gogh Museum, inv. no. b3 V/1962", letter.getMuseum());

		
	}
	
	@Test
	public void getLetter85Test()
			throws MalformedURLException, HtmlLetterParserException {

		URL url = new URL(
				"http://vangoghletters.org/vg/letters/let085/letter.html");
		VanGoghLetterHtmlParser vanGoghLetterParser = new VanGoghLetterHtmlParser();
		IHtmlLetterParser htmlParser = new HtmlLetterParser();

		vanGoghLetterParser.setHtmlLetterParser(htmlParser);
		Letter letter = vanGoghLetterParser.getLetter(url);

		Assert.assertNotNull(letter);
		Assert.assertNotNull(letter.getText());
		Assert.assertNotNull(letter.getFrom());
		Assert.assertTrue(letter.getText().trim().length() > 0);

		System.out.println("Titolo: "+letter.getTitle());
		System.out.println("To: "+letter.getTo());
		System.out.println("From: "+letter.getFrom());
		System.out.println("Date: "+letter.getDate());
		System.out.println("Place: "+letter.getPlace());
		System.out.println("Location: "+letter.getMuseum());
		
		Assert.assertEquals("Theo van Gogh", letter.getTo());
		Assert.assertEquals("Vincent van Gogh", letter.getFrom());
		Assert.assertEquals("Monday, 3 or Tuesday, 4 July 1876", letter.getDate());
		Assert.assertEquals("Isleworth", letter.getPlace());
		Assert.assertEquals("Amsterdam, Van Gogh Museum, inv. no. b83 V/1962", letter.getMuseum());

		
	}
	
	@Test
	public void getLetter627Test()
			throws MalformedURLException, HtmlLetterParserException {

		URL url = new URL(
				"http://vangoghletters.org/vg/letters/let627/letter.html");
		VanGoghLetterHtmlParser vanGoghLetterParser = new VanGoghLetterHtmlParser();
		IHtmlLetterParser htmlParser = new HtmlLetterParser();

		vanGoghLetterParser.setHtmlLetterParser(htmlParser);
		Letter letter = vanGoghLetterParser.getLetter(url);

		Assert.assertNotNull(letter);
		Assert.assertNotNull(letter.getText());
		Assert.assertNotNull(letter.getFrom());
		Assert.assertTrue(letter.getText().trim().length() > 0);

		System.out.println("Titolo: "+letter.getTitle());
		System.out.println("To: "+letter.getTo());
		System.out.println("From: "+letter.getFrom());
		System.out.println("Date: "+letter.getDate());
		System.out.println("Place: "+letter.getPlace());
		System.out.println("Location: "+letter.getMuseum());
		
		Assert.assertEquals("John Peter Russell", letter.getTo());
		Assert.assertEquals("Vincent van Gogh", letter.getFrom());
		Assert.assertEquals("on or about Sunday, 17 June 1888.", letter.getDate());
		Assert.assertEquals("Arles", letter.getPlace());
		Assert.assertEquals("New York, Guggenheim Museum. Thannhauser Collection. Inv. no. 78.2514T19.", letter.getMuseum());
		
	}

	@Test
	public void getLetterRM10Test()
			throws MalformedURLException, HtmlLetterParserException {

		URL url = new URL(
				"http://vangoghletters.org/vg/letters/RM10/letter.html");
		VanGoghLetterHtmlParser vanGoghLetterParser = new VanGoghLetterHtmlParser();
		IHtmlLetterParser htmlParser = new HtmlLetterParser();

		vanGoghLetterParser.setHtmlLetterParser(htmlParser);
		Letter letter = vanGoghLetterParser.getLetter(url);

		Assert.assertNotNull(letter);
		Assert.assertNotNull(letter.getText());
		Assert.assertNotNull(letter.getFrom());
		Assert.assertTrue(letter.getText().trim().length() > 0);

		System.out.println("Titolo: "+letter.getTitle());
		System.out.println("To: "+letter.getTo());
		System.out.println("From: "+letter.getFrom());
		System.out.println("Date: "+letter.getDate());
		System.out.println("Place: "+letter.getPlace());
		System.out.println("Location: "+letter.getMuseum());
		
		Assert.assertEquals("Theo van Gogh", letter.getTo());
		Assert.assertEquals("Vincent van Gogh", letter.getFrom());
		Assert.assertEquals("probably February-March 1877", letter.getDate());
		Assert.assertEquals("Dordrecht?", letter.getPlace());
		Assert.assertEquals("Amsterdam, Van Gogh Museum, inv. no. b1465 V/1962", letter.getMuseum());
		
	}
	
	@Test
	public void getLetter883Test()
			throws MalformedURLException, HtmlLetterParserException {

		URL url = new URL(
				"http://vangoghletters.org/vg/letters/let883/letter.html");
		VanGoghLetterHtmlParser vanGoghLetterParser = new VanGoghLetterHtmlParser();
		IHtmlLetterParser htmlParser = new HtmlLetterParser();

		vanGoghLetterParser.setHtmlLetterParser(htmlParser);
		Letter letter = vanGoghLetterParser.getLetter(url);

		Assert.assertNotNull(letter);
		Assert.assertNotNull(letter.getText());
		Assert.assertNotNull(letter.getFrom());
		Assert.assertTrue(letter.getText().trim().length() > 0);

		System.out.println("Titolo: "+letter.getTitle());
		System.out.println("To: "+letter.getTo());
		System.out.println("From: "+letter.getFrom());
		System.out.println("Date: "+letter.getDate());
		System.out.println("Place: "+letter.getPlace());
		System.out.println("Location: "+letter.getMuseum());
		
		Assert.assertEquals("Joseph Ginoux and Marie Ginoux-Julien", letter.getTo());
		Assert.assertEquals("Vincent van Gogh", letter.getFrom());
		Assert.assertEquals("Wednesday, 11 June 1890", letter.getDate());
		Assert.assertEquals("Auvers-sur-Oise", letter.getPlace());
		Assert.assertEquals("Norton Simon Museum, Norton Simon Art Foundation, Pasadena, CA., inv. no. M.1989.1.14.L", letter.getMuseum());

		
	}
	
	@Test
	public void getLetter848Test()
			throws MalformedURLException, HtmlLetterParserException {

		URL url = new URL(
				"http://vangoghletters.org/vg/letters/let848/letter.html");
		VanGoghLetterHtmlParser vanGoghLetterParser = new VanGoghLetterHtmlParser();
		IHtmlLetterParser htmlParser = new HtmlLetterParser();

		vanGoghLetterParser.setHtmlLetterParser(htmlParser);
		Letter letter = vanGoghLetterParser.getLetter(url);

		Assert.assertNotNull(letter);
		Assert.assertNotNull(letter.getText());
		Assert.assertNotNull(letter.getFrom());
		Assert.assertTrue(letter.getText().trim().length() > 0);

		System.out.println("Titolo: "+letter.getTitle());
		System.out.println("To: "+letter.getTo());
		System.out.println("From: "+letter.getFrom());
		System.out.println("Date: "+letter.getDate());
		System.out.println("Place: "+letter.getPlace());
		System.out.println("Location: "+letter.getMuseum());
		
		Assert.assertEquals("Vincent van Gogh", letter.getTo());
		Assert.assertEquals("Theo van Gogh and Jo van Gogh-Bonger", letter.getFrom());
		Assert.assertEquals("Friday, 31 January 1890", letter.getDate());
		Assert.assertEquals("Paris", letter.getPlace());
		Assert.assertEquals("Amsterdam, Van Gogh Museum, inv. nos. b1493 a-b V/1962", letter.getMuseum());
		
	}
	
	@Test
	public void getLetter523Test()
			throws MalformedURLException, HtmlLetterParserException {

		URL url = new URL(
				"http://vangoghletters.org/vg/letters/let523/letter.html");
		VanGoghLetterHtmlParser vanGoghLetterParser = new VanGoghLetterHtmlParser();
		IHtmlLetterParser htmlParser = new HtmlLetterParser();

		vanGoghLetterParser.setHtmlLetterParser(htmlParser);
		Letter letter = vanGoghLetterParser.getLetter(url);

		Assert.assertNotNull(letter);
		Assert.assertNotNull(letter.getText());
		Assert.assertNotNull(letter.getFrom());
		Assert.assertTrue(letter.getText().trim().length() > 0);

		System.out.println("Titolo: "+letter.getTitle());
		System.out.println("To: "+letter.getTo());
		System.out.println("From: "+letter.getFrom());
		System.out.println("Date: "+letter.getDate());
		System.out.println("Place: "+letter.getPlace());
		System.out.println("Location: "+letter.getMuseum());
		
		Assert.assertEquals("Hendrik Jan Furnée", letter.getTo());
		Assert.assertEquals("Vincent van Gogh", letter.getFrom());
		Assert.assertEquals("Wednesday, 5 August 1885", letter.getDate());
		Assert.assertEquals("Nuenen", letter.getPlace());
		Assert.assertEquals("Amsterdam, Van Gogh Museum, inv. nos. b458 a-c V/1962", letter.getMuseum());
		
	}
	
	@Test
	public void getLetter759Test()
			throws MalformedURLException, HtmlLetterParserException {

		URL url = new URL(
				"http://vangoghletters.org/vg/letters/let759/letter.html");
		VanGoghLetterHtmlParser vanGoghLetterParser = new VanGoghLetterHtmlParser();
		IHtmlLetterParser htmlParser = new HtmlLetterParser();

		vanGoghLetterParser.setHtmlLetterParser(htmlParser);
		Letter letter = vanGoghLetterParser.getLetter(url);

		Assert.assertNotNull(letter);
		Assert.assertNotNull(letter.getText());
		Assert.assertNotNull(letter.getFrom());
		Assert.assertTrue(letter.getText().trim().length() > 0);

		System.out.println("Titolo: "+letter.getTitle());
		System.out.println("To: "+letter.getTo());
		System.out.println("From: "+letter.getFrom());
		System.out.println("Date: "+letter.getDate());
		System.out.println("Place: "+letter.getPlace());
		System.out.println("Location: "+letter.getMuseum());
		
		Assert.assertEquals("Vincent van Gogh", letter.getTo());
		Assert.assertEquals("Hendrik Bonger, Hermine Bonger-Weismann and Anna van Gogh-Carbentus", letter.getFrom());
		Assert.assertEquals("Thursday, 18 April 1889", letter.getDate());
		Assert.assertEquals("Amsterdam/Breda/Paris", letter.getPlace());
		Assert.assertEquals("Amsterdam, Van Gogh Museum, inv. no. b1492 a-c V/1962", letter.getMuseum());
		
	}
	
	@Test
	public void getLetter693Test()
			throws MalformedURLException, HtmlLetterParserException {

		URL url = new URL(
				"http://vangoghletters.org/vg/letters/let693/letter.html");
		VanGoghLetterHtmlParser vanGoghLetterParser = new VanGoghLetterHtmlParser();
		IHtmlLetterParser htmlParser = new HtmlLetterParser();

		vanGoghLetterParser.setHtmlLetterParser(htmlParser);
		Letter letter = vanGoghLetterParser.getLetter(url);

		Assert.assertNotNull(letter);
		Assert.assertNotNull(letter.getText());
		Assert.assertNotNull(letter.getFrom());
		Assert.assertTrue(letter.getText().trim().length() > 0);

		System.out.println("Titolo: "+letter.getTitle());
		System.out.println("To: "+letter.getTo());
		System.out.println("From: "+letter.getFrom());
		System.out.println("Date: "+letter.getDate());
		System.out.println("Place: "+letter.getPlace());
		System.out.println("Location: "+letter.getMuseum());
		
		Assert.assertEquals("Eugène Boch", letter.getTo());
		Assert.assertEquals("Vincent van Gogh", letter.getFrom());
		Assert.assertEquals("Tuesday, 2 October 1888", letter.getDate());
		Assert.assertEquals("Arles", letter.getPlace());
		Assert.assertEquals("Amsterdam, Van Gogh Museum, inv. nos. b598 a-c V/1962", letter.getMuseum());
		
	}
	
	@Test
	public void getLetter264Test()
			throws MalformedURLException, HtmlLetterParserException {

		URL url = new URL(
				"http://vangoghletters.org/vg/letters/let264/letter.html");
		VanGoghLetterHtmlParser vanGoghLetterParser = new VanGoghLetterHtmlParser();
		IHtmlLetterParser htmlParser = new HtmlLetterParser();

		vanGoghLetterParser.setHtmlLetterParser(htmlParser);
		Letter letter = vanGoghLetterParser.getLetter(url);

		Assert.assertNotNull(letter);
		Assert.assertNotNull(letter.getText());
		Assert.assertNotNull(letter.getFrom());
		Assert.assertTrue(letter.getText().trim().length() > 0);

		System.out.println("Titolo: "+letter.getTitle());
		System.out.println("To: "+letter.getTo());
		System.out.println("From: "+letter.getFrom());
		System.out.println("Date: "+letter.getDate());
		System.out.println("Place: "+letter.getPlace());
		System.out.println("Location: "+letter.getMuseum());
		
		Assert.assertEquals("Theo van Gogh", letter.getTo());
		Assert.assertEquals("Vincent van Gogh", letter.getFrom());
		Assert.assertEquals("Sunday, 17 September 1882", letter.getDate());
		Assert.assertEquals("The Hague", letter.getPlace());
		Assert.assertEquals("Amsterdam, Van Gogh Museum, inv. no. b253 a V/1962", letter.getMuseum());

		
	}
}
