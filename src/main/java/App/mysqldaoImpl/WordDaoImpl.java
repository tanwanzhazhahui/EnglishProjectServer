package App.mysqldaoImpl;


import App.vo.Word;
import App.mysqldao.WordDao;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WordDaoImpl extends HibernateDaoSupport implements WordDao {
    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }
    @Override
    public void AddWord(Word word) {
        getHibernateTemplate().save(word);
    }

    @Override
    public void UpdateWord(Word word) {
        getHibernateTemplate().update(word);
    }

    @Override
    public void DeleteWord(Word word) {
        getHibernateTemplate().delete(word);
    }

    @Override
    public Word findWordById(Integer id) {
        return getHibernateTemplate().get(Word.class,id);
    }

    @Override
    public List<Word> getAllWords() {
        List<Word> words=(List<Word>)getHibernateTemplate().find("from Word");
        return words;
    }

    @Override
    public List<Word> getTenBook1Words() {
        List<Word> words=(List<Word>)getHibernateTemplate().execute(new HibernateCallback() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                String sql="select * from word where bid=1 order by rand() limit 10";
                List<Word> words=(List<Word>)session.createSQLQuery(sql).addEntity(Word.class).list();
                return words;
            }
        });
        return words;
    }
}
