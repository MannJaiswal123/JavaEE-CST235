package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Verse {

	private String book, chapter, verse, result;

	/**
	 * 
	 */
	public Verse() {
		this.book = "";
		this.chapter = "";
		this.verse = "";
		this.result = "";
	}

	/**
	 * @param book
	 * @param chapter
	 * @param verse
	 * @param result
	 */
	public Verse(String book, String chapter, String verse, String result) {

		this.book = book;
		this.chapter = chapter;
		this.verse = verse;
		this.result = result;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public String getChapter() {
		return chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

	public String getVerse() {
		return verse;
	}

	public void setVerse(String verse) {
		this.verse = verse;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
