package org.neo4art.htmlparser.bean;

import java.util.Vector;

/**
 * 
 * @author Enrico
 *
 */
public class Letter {
	
	String place;
	String text;
	String from;
	String to;
	String date;
	String url;
	String title;
	String museum;
	Vector<String> link;

	public Letter() {
		
		this.place = "";
		this.text = "";
		this.from = "";
		this.to = "";
		this.date = "";
		this.url = "";
		this.title = "";
		this.museum = "";
	}

	public Letter(String place, String text, String from, String to,
			String date, String url, String museum) {
		this.place = place;
		this.text = text;
		this.from = from;
		this.to = to;
		this.date = date;
		this.url = url;
		this.museum = museum;
	}
	
	public void setLink(Vector<String> linkV){
		this.link = linkV;
	}
	
	public Vector<String> getLink(){
		return link;
	}
	
	public String getMuseum() {
		return museum;
	}

	public void setMuseum(String museum) {
		this.museum = museum;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
