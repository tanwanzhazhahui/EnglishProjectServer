package App.mysqlserviceImpl;

import App.vo.Word;
import App.mysqldao.WordDao;
import App.mysqlservice.WordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional(readOnly = false)
@Service("WordService")
public class WordServiceImpl implements WordService {

    @Resource private WordDao wordDao;

    @Override
    public void AddWord(Word word) {
        wordDao.AddWord(word);
    }

    @Override
    public void UpdateWord(Word word) {
        wordDao.UpdateWord(word);
    }

    @Override
    public void DeleteWord(Word word) {
        wordDao.DeleteWord(word);
    }

    @Override
    public Word findWordById(Integer id) {
        return wordDao.findWordById(id);
    }

    @Override
    public List<Word> getAllWords() {
        return wordDao.getAllWords();
    }

    @Override
    public List<Word> getTenBook1Words() {
        return wordDao.getTenBook1Words();
    }
}
