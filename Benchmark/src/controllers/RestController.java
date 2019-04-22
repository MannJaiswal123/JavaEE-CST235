/*
 * Mann Jaiswal
 * CST-235 (JavaEE)
 * Jevon Jackson
 * April 21, 2019. 
 * (This is my own work).
 */
package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import beans.Verse;
import business.RestService;

@ManagedBean
public class RestController 
{
	@Inject
	RestService rs;
	
public void onSubmit(Verse script)
{
	String strg = "http://bible-api.com/" + script.getBook()+  "+"+ script.getChapter() +":"+ script.getVerse() +"?callback=func";
	
	script.setResult(rs.retrieveJSON(strg));
		
}
		
}
