package kr.co.kopo.service;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import kr.co.kopo.model.Book;
import kr.co.kopo.model.Fileupload;
import kr.co.kopo.pager.Pager;

public interface BookService {

	List<Book> list();

	void dummy();

	void init();

	List<Book> getBookList(Pager pager);

	void addBook(Book book, MultipartFile[] uploadFile, Model model) throws Exception;

	Book getBook(int bookId);

	void updateBook(Book book);

	void deleteBook(int bookId);

}
