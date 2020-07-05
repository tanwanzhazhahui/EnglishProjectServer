package App.mysqlservice;

import App.vo.ErrorWord;

import java.util.List;

public interface ErrorWordService {
    public void AddErrorWord(ErrorWord errorword);
    public void UpdateErrorWord(ErrorWord errorword);
    public void DeleteErrorWord(ErrorWord errorword);
    public ErrorWord findErrorWordById(Integer id);
    public List<ErrorWord> getThirtyErrorWords();
}
