package App.mysqlservice;

import App.vo.Book;

import java.util.List;

public interface BookService {
    public void AddNewBook(Book book);
    public void UpdateBook(Book book);
    public void DeleteBook(Book book);
    public Book findBookById(Integer id);
    public List<Book> getAllBooks();
}
