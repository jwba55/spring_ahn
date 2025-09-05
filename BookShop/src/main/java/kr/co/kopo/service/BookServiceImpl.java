package kr.co.kopo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import kr.co.kopo.dao.BookDao;
import kr.co.kopo.model.Book;
import kr.co.kopo.model.Fileupload;
import kr.co.kopo.pager.Pager;
import kr.co.kopo.util.FileuploadUtil;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	FileuploadUtil fileuploadUtil;
	
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

	@Transactional
	@Override
	public void addBook(Book book, MultipartFile[] uploadFile, Model model) throws Exception {
		//도서 정보를 저장하고 키 값 가져오기
		int bookId = bookDao.addBook(book);
		
		for (MultipartFile file: uploadFile) {
			if(!file.isEmpty()) {
				Fileupload fileupload = new Fileupload();
				//모듈화 된 파일 업로드
				String filename = fileuploadUtil.saveFile(file, model);
				//파일번호는 시퀀스 사용
				fileupload.setFileName(filename);
				fileupload.setBookId(bookId);	//가져온 키 값 사용
				bookDao.addFileupload(fileupload);
			}
		}
		
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
			book.setBookPrice(1000+i);
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
