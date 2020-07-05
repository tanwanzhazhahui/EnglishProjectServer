package App.mysqlserviceImpl;

import App.vo.StudyPlan;
import App.mysqldao.StudyPlanDao;
import App.mysqlservice.StudyPlanService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional(readOnly = false)
@Service("StudyPlanService")
public class StudyPlanServiceImpl implements StudyPlanService {

    @Resource private StudyPlanDao studyPlanDao;

    @Override
    public void AddNewStudyPlan(StudyPlan studyplan) {
        studyPlanDao.AddNewStudyPlan(studyplan);
    }

    @Override
    public void UpdateStudyPlan(StudyPlan studyplan) {
        studyPlanDao.UpdateStudyPlan(studyplan);
    }

    @Override
    public void DeleteStudyPlan(StudyPlan studyplan) {
        studyPlanDao.DeleteStudyPlan(studyplan);
    }

    @Override
    public StudyPlan findStudyPlanById(Integer id) {
        return studyPlanDao.findStudyPlanById(id);
    }

    @Override
    public List<StudyPlan> getAllStudyPlans() {
        return studyPlanDao.getAllStudyPlans();
    }
}
