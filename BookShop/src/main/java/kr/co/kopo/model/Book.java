package kr.co.kopo.model;

import java.util.List;

public class Book {
	
	private int bookId;
	private String bookName;
	private String publisher;
	private int bookPrice;
	private String pubDate;
	private List<Fileupload> fileupload;
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	public List<Fileupload> getFileupload() {
		return fileupload;
	}
	public void setFileupload(List<Fileupload> fileupload) {
		this.fileupload = fileupload;
	}
}
