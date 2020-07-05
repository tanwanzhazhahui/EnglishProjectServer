package App.mysqldaoImpl;

import App.vo.Book;
import App.mysqldao.BookDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl extends HibernateDaoSupport implements BookDao {

    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public void AddNewBook(Book book) {
        getHibernateTemplate().save(book);
    }

    @Override
    public void UpdateBook(Book book) {
        getHibernateTemplate().update(book);
    }

    @Override
    public void DeleteBook(Book book) {
        getHibernateTemplate().delete(book);
    }

    @Override
    public Book findBookById(Integer id) {
        return getHibernateTemplate().get(Book.class,id);
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> books=(List<Book>)getHibernateTemplate().find("from Book");
        return books;
    }


}
