package App.mysqldaoImpl;


import App.vo.User;
import App.vo.UsersBooks;
import App.mysqldao.UserDao;
import App.mysqldao.UsersBooksDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Set;

@Repository
public class UsersBooksDaoImpl extends HibernateDaoSupport implements UsersBooksDao {
    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }

    @Resource
    private UserDao userDao;

    @Override
    public void AddUsersBooks(UsersBooks usersBooks) {
        getHibernateTemplate().save(usersBooks);
    }

    @Override
    public void UpdateUsersBooks(UsersBooks usersBooks) {
        getHibernateTemplate().update(usersBooks);
    }

    @Override
    public void DeleteUsersBooks(UsersBooks usersBooks) {
        getHibernateTemplate().delete(usersBooks);
    }

    @Override
    public Set<UsersBooks> getUsersBooksByPhonenumber(String phonenumber) {
        User user=userDao.getUserByPhonenumber(phonenumber);
        Set<UsersBooks> usersBooks=user.getUsersbooks();
        return usersBooks;
    }
}
