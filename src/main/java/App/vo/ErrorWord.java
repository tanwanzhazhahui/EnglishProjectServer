package App.vo;

public class ErrorWord {
    private int ewid;
    private String word;
    private String type;
    private String mean;

    public ErrorWord(){ }

    public ErrorWord(String word,String type,String mean){
        this.word=word;
        this.type=type;
        this.mean=mean;
    }


    public int getEwid() {
        return ewid;
    }

    public void setEwid(int ewid) {
        this.ewid = ewid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }


}
