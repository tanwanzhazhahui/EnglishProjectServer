package App.mysqldao;

import App.vo.Book;

import java.util.List;

public interface BookDao {
    public void AddNewBook(Book book);
    public void UpdateBook(Book book);
    public void DeleteBook(Book book);
    public Book findBookById(Integer id);
    public List<Book> getAllBooks();
}
