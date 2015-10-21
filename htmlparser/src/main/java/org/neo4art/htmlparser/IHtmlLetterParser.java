package org.neo4art.htmlparser;

import java.net.URL;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.sax.LinkContentHandler;
import org.neo4art.htmlparser.exception.HtmlLetterParserException;

/**
 * 
 * @author Enrico
 *
 */
public interface IHtmlLetterParser {

	/**
     * Method that returns an html page from an url adress.
     * 
     * @param Url - the url.
     * 
     * @throws HtmlLetterParserException - if the parser has an error. 
     */
   String getHtmlPageByUrl(URL url) throws HtmlLetterParserException;
   
   Metadata getMetadata();
	
   LinkContentHandler getLinkHandler();
}
