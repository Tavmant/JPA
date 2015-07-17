package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.List;

import ua.lviv.lgs.dao.AuthorDao;
import ua.lviv.lgs.dao.BookDao;
import ua.lviv.lgs.dao.DaoFactory;

public class Main {

	public static void main(String[] args) {

		AuthorDao aDao = DaoFactory.getInstance().getAuthorDao();
		BookDao bDao = DaoFactory.getInstance().getBookDao();
		Author a = new Author("Taras Shevchenko", 56);

		Book b = new Book("Kobzar");
		a.addBook(b);

		aDao.create(a);
//		System.out.println(bDao.findByTitle("Kobzar"));
//		System.out.println(aDao.findByAge(56));
		
//		List<Author> aList = aDao.findAll("Author");
//		for (Author author : aList) {
//			System.out.println(author);
//		}
		
//		List<Book> bList = bDao.findAll("Book");
//		for (Book book : bList) {
//			System.out.println(book);
//		}
		
//		Author a1 = aDao.findById(1);
//		a1.setAge(45);
//		aDao.update(a1);
		
//		Author a2 = aDao.findById(1);
//		aDao.delete(a2);
		
		
		DaoFactory.getInstance().close();
	}

}
