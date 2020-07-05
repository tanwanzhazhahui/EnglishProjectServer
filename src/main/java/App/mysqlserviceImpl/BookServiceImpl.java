package App.mysqlserviceImpl;

import App.vo.Book;
import App.mysqldao.BookDao;
import App.mysqlservice.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional(readOnly = false)
@Service("BookService")
public class BookServiceImpl implements BookService {

    @Resource private BookDao bookDao;

    @Override
    public void AddNewBook(Book book) {
        bookDao.AddNewBook(book);
    }

    @Override
    public void UpdateBook(Book book) {
        bookDao.UpdateBook(book);
    }

    @Override
    public void DeleteBook(Book book) {
        bookDao.DeleteBook(book);
    }

    @Override
    public Book findBookById(Integer id) {
        return bookDao.findBookById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }
}
