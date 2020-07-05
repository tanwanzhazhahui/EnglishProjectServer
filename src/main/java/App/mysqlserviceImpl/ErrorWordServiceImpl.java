package App.mysqlserviceImpl;

import App.vo.ErrorWord;
import App.mysqldao.ErrorWordDao;
import App.mysqlservice.ErrorWordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional(readOnly = false)
@Service("ErrorWordService")
public class ErrorWordServiceImpl implements ErrorWordService {

    @Resource private ErrorWordDao errorWordDao;

    @Override
    public void AddErrorWord(ErrorWord errorword) {
        errorWordDao.AddErrorWord(errorword);
    }

    @Override
    public void UpdateErrorWord(ErrorWord errorword) {
        errorWordDao.UpdateErrorWord(errorword);
    }

    @Override
    public void DeleteErrorWord(ErrorWord errorword) {
        errorWordDao.DeleteErrorWord(errorword);
    }

    @Override
    public ErrorWord findErrorWordById(Integer id) {
        return errorWordDao.findErrorWordById(id);
    }

    @Override
    public List<ErrorWord> getThirtyErrorWords() {
        return errorWordDao.getThirtyErrorWords();
    }
}
