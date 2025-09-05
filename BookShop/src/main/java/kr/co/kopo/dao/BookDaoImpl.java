package kr.co.kopo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kopo.model.Book;
import kr.co.kopo.model.Fileupload;
import kr.co.kopo.pager.Pager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class BookDaoImpl implements BookDao {
	
	@Autowired
	SqlSession sql;

	@Override
	public List<Book> getBookList(Pager pager) {
		return sql.selectList("book.list", pager);
	}

	@Override
	public int addBook(Book book) {
		sql.insert("book.addBook", book);
		int bookid = book.getBookId();
		log.info("도서번호" + bookid);
		return bookid;
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

	@Override
	public void addFileupload(Fileupload fileupload) {
		log.info("파일 도서 번호: " + fileupload.getBookId());
		sql.insert("book.fileupload", fileupload);
	}

}
