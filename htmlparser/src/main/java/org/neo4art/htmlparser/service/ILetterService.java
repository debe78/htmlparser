/**
 * 
 */
package org.neo4art.htmlparser.service;

import java.nio.file.Path;
import java.util.List;

import org.neo4art.htmlparser.bean.Letter;
import org.neo4art.htmlparser.exception.LetterParserException;

/**
 * @author Enrico
 *
 */
public interface ILetterService {

  /**
   * Method that save a letter into the giving path.
   * 
   * @param Letter - the letter to save. 
   * @param Path - the path where save the letter
   */
  void	saveLetterFromUrl(Letter letter,Path path);
  
  /**
   * Method that returns the list of the letters stored in the path.
   * 
   * @param path - the path  where there are files.
   * @return - the list of the letters.
   * @throws LetterParserException - if the parser has an error. 
   */
  List<Letter> getLettersFromPath(Path path) throws LetterParserException;
	
}
