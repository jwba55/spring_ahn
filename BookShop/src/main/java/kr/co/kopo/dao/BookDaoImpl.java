package kr.co.kopo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kopo.model.Book;
import kr.co.kopo.pager.Pager;


@Repository
public class BookDaoImpl implements BookDao {
	
	@Autowired
	SqlSession sql;

	@Override
	public List<Book> getBookList(Pager pager) {
		return sql.selectList("book.list", pager);
	}

	@Override
	public void addBook(Book book) {
		sql.insert("book.addBook", book);
	}

	@Override
	public Book getBook(int bookId) {
		return sql.selectOne("book.getBook",bookId);
	}

	@Override
	public void updateBook(Book book) {
		sql.update("book.updateBook",book);
	}

	@Override
	public void deleteBook(int bookId) {
		sql.delete("book.deleteBook",bookId);
	}


	@Override
	public int getTotal(Pager pager) {
		return sql.selectOne("book.total",pager);
	}

}
