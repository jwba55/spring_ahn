package kr.co.kopo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kopo.dao.BookDao;
import kr.co.kopo.model.Book;
import kr.co.kopo.pager.Pager;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookDao bookDao;

	@Override
	public List<Book> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getBookList(Pager pager) {
		int toal = bookDao.getTotal(pager);
		pager.setTotal(toal);
		
		return bookDao.getBookList(pager);
		
		
	}

	@Override
	public void addBook(Book book) {
		bookDao.addBook(book);
		
	}

	@Override
	public Book getBook(int bookId) {
		return bookDao.getBook(bookId);
	}

	@Override
	public void updateBook(Book book) {
		bookDao.updateBook(book);
	}

	@Override
	public void deleteBook(int bookId) {
		bookDao.deleteBook(bookId);
	}

	@Override
	public void dummy() {
		for (int i = 1; i <= 100; i++) {
			Book book = new Book();
			book.setBookName("도서명"+i);
			book.setPrice(1000+i);
			book.setPublisher("출판사"+i);
			book.setPubDate("2025/09/01");
			bookDao.addBook(book);
		}
	}

	@Override
	public void init() {
		Pager pager = new Pager();
		pager.setPerPage(0);
		
		List<Book> list = bookDao.getBookList(pager);
		
		for (Book item : list) {
			bookDao.deleteBook(item.getBookId());
		}
		
	}

}
