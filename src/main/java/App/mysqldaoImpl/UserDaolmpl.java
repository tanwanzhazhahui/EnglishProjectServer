package App.mysqldaoImpl;


import App.vo.*;
import App.mysqldao.BookDao;
import App.mysqldao.StudyPlanDao;
import App.mysqldao.UserDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;


@Repository
public class UserDaolmpl extends HibernateDaoSupport implements UserDao {
    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }

    @Resource private BookDao bookDao;
    @Resource private StudyPlanDao studyplanDao;

    @Override
    public void AddNewUser(User user) {
        Book book=bookDao.findBookById(1);
        StudyPlan studyplan1=studyplanDao.findStudyPlanById(1);

        Wallet wallet=new Wallet();
        user.setWallet(wallet);
        wallet.setUser(user);

        UsersBooks usersBooks=new UsersBooks();
        usersBooks.setUser(user);
        usersBooks.setBook(book);
        usersBooks.setStudyplan(studyplan1);
        user.getUsersbooks().add(usersBooks);
        getHibernateTemplate().saveOrUpdate(user);
    }

    @Override
    public void UpdateUser(User user) {
        getHibernateTemplate().update(user);
    }

    @Override
    public void DeleteUser(User user) {
        getHibernateTemplate().delete(user);
    }

    @Override
    public User getUserByPhonenumber(String phoenumber) {
        String hql="from User where phonenumber=:phonenumber";
        String paramName="phonenumber";
        String value=phoenumber;
        List<User> userList=(List<User>)getHibernateTemplate().findByNamedParam(hql,paramName,value);
        Iterator iterator=userList.iterator();
        return (User)iterator.next();
    }

    @Override
    public void UpdateAvatorByPhonenumber(String phonenumber, String avator) {
        User user=getUserByPhonenumber(phonenumber);
        user.setAvator(avator);
        getHibernateTemplate().update(user);
    }
}
