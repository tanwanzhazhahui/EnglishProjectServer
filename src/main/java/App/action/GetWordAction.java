package App.action;


import App.jsonvo.JsonErrorWord;
import App.jsonvo.JsonWord;
import App.vo.*;
import App.mysqlservice.ErrorWordService;
import App.mysqlservice.WordService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("prototype")
public class GetWordAction extends ActionSupport {
    //将会被Struts2序列化为JSON字符串的对象
    private List<JsonWord> wordList;
    private List<JsonErrorWord> errorwordList;


    private String phonenumber;//获得服务器送来的phonenumber
    private String param;//请求参数

    public ApplicationContext ctx=new ClassPathXmlApplicationContext("ApplicationContext.xml");
    public WordService wordService=(WordService)ctx.getBean("WordService");
    public ErrorWordService errorWordService=(ErrorWordService)ctx.getBean("ErrorWordService");

    public String getTenBook1Words(){
        if(param.equals("8a68acd94ca0743ebea2dccce11788c4")){
            List<Word> words=wordService.getTenBook1Words();
            wordList=new ArrayList<JsonWord>();
            for(int i=0;i<words.size();i++){
                Word word=words.get(i);
                JsonWord jsonWord=new JsonWord(word.getWord(),word.getType(),word.getMean(),word.getSentence(),word.getInterpret(),word.getPhrase());
                wordList.add(jsonWord);
            }
            return SUCCESS;
        }else {
            return INPUT;
        }
    }


    public String getThirtyErrorWords(){
        if(param.equals("8a68acd94ca0743ebea2dccce11788c4")){
            List<ErrorWord> errorwords=errorWordService.getThirtyErrorWords();
            errorwordList=new ArrayList<JsonErrorWord>();
            for(int i=0;i<errorwords.size();i++){
                ErrorWord errorord=errorwords.get(i);
                JsonErrorWord jsonErrorWord=new JsonErrorWord(errorord.getWord(),errorord.getType(),errorord.getMean());
                errorwordList.add(jsonErrorWord);
            }
            return SUCCESS;
        }else {
            return INPUT;
        }
    }


    public List<JsonWord> getWordList() {
        return wordList;
    }

    public void setWordList(List<JsonWord> wordList) {
        this.wordList = wordList;
    }

    public List<JsonErrorWord> getErrorwordList() {
        return errorwordList;
    }

    public void setErrorwordList(List<JsonErrorWord> errorwordList) {
        this.errorwordList = errorwordList;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

}
