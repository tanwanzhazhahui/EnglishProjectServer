package App.mysqldao;

import App.vo.StudyPlan;

import java.util.List;

public interface StudyPlanDao {
    public void AddNewStudyPlan(StudyPlan studyplan);
    public void UpdateStudyPlan(StudyPlan studyplan);
    public void DeleteStudyPlan(StudyPlan studyplan);
    public StudyPlan findStudyPlanById(Integer id);
    public List<StudyPlan> getAllStudyPlans();
}
