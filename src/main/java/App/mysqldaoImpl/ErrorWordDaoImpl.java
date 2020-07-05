package App.mysqldaoImpl;

import App.vo.ErrorWord;
import App.mysqldao.ErrorWordDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ErrorWordDaoImpl extends HibernateDaoSupport implements ErrorWordDao {

    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public void AddErrorWord(ErrorWord errorword) {
        getHibernateTemplate().save(errorword);
    }

    @Override
    public void UpdateErrorWord(ErrorWord errorword) {
        getHibernateTemplate().update(errorword);
    }

    @Override
    public void DeleteErrorWord(ErrorWord errorword) {
        getHibernateTemplate().delete(errorword);
    }

    @Override
    public ErrorWord findErrorWordById(Integer id) {
        return getHibernateTemplate().get(ErrorWord.class,id);
    }

    @Override
    public List<ErrorWord> getThirtyErrorWords() {
        List<ErrorWord> errorwords=(List<ErrorWord>)getHibernateTemplate().execute(new HibernateCallback() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                String sql="select * from errorword order by rand() limit 30";
                List<ErrorWord> errorwords=(List<ErrorWord>)session.createSQLQuery(sql).addEntity(ErrorWord.class).list();
                return errorwords;
            }
        });
        return errorwords;
    }
}
