package App.mysqldaoImpl;


import App.vo.StudyPlan;
import App.mysqldao.StudyPlanDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudyPlanDaoImpl extends HibernateDaoSupport implements StudyPlanDao {
    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public void AddNewStudyPlan(StudyPlan studyplan) {
        getHibernateTemplate().save(studyplan);
    }

    @Override
    public void UpdateStudyPlan(StudyPlan studyplan) {
        getHibernateTemplate().update(studyplan);
    }

    @Override
    public void DeleteStudyPlan(StudyPlan studyplan) {
        getHibernateTemplate().delete(studyplan);
    }

    @Override
    public StudyPlan findStudyPlanById(Integer id) {
        return getHibernateTemplate().get(StudyPlan.class,id);
    }

    @Override
    public List<StudyPlan> getAllStudyPlans() {
        List<StudyPlan> studyplans=(List<StudyPlan>)getHibernateTemplate().find("from StudyPlan ");
        return studyplans;
    }
}
