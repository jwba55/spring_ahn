package kr.co.kopo.dao;

import java.util.List;

import kr.co.kopo.model.Book;
import kr.co.kopo.model.Fileupload;
import kr.co.kopo.pager.Pager;

public interface BookDao {

	int getTotal(Pager pager);

	List<Book> getBookList(Pager pager);

	int addBook(Book book);

	Book getBook(int bookId);

	void updateBook(Book book);

	void deleteBook(int bookId);

	void addFileupload(Fileupload fileupload);

}
