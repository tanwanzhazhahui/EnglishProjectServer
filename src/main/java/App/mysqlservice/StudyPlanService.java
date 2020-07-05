package App.mysqlservice;

import App.vo.StudyPlan;

import java.util.List;

public interface StudyPlanService {
    public void AddNewStudyPlan(StudyPlan studyplan);
    public void UpdateStudyPlan(StudyPlan studyplan);
    public void DeleteStudyPlan(StudyPlan studyplan);
    public StudyPlan findStudyPlanById(Integer id);
    public List<StudyPlan> getAllStudyPlans();
}
