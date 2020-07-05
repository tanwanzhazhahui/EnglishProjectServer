package App.jsonvo;

public class JsonErrorWord {
    private String word;
    private String type;
    private String mean;

    public JsonErrorWord(){ }

    public JsonErrorWord(String word,String type,String mean){
        this.word=word;
        this.type=type;
        this.mean=mean;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }


}
