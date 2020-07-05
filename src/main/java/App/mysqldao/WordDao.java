package App.mysqldao;

import App.vo.Word;

import java.util.List;

public interface WordDao {
    public void AddWord(Word word);
    public void UpdateWord(Word word);
    public void DeleteWord(Word word);
    public Word findWordById(Integer id);
    public List<Word> getAllWords();
    public List<Word> getTenBook1Words();
}
