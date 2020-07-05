package App.vo;

public class StudyPlan {
    private Integer spid;
    private String pname;
    private Integer dailyphrase;
    private Double reward;

    public Integer getSpid() {
        return spid;
    }

    public void setSpid(Integer spid) {
        this.spid = spid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getDailyphrase() {
        return dailyphrase;
    }

    public void setDailyphrase(Integer dailyphrase) {
        this.dailyphrase = dailyphrase;
    }

    public Double getReward() {
        return reward;
    }

    public void setReward(Double reward) {
        this.reward = reward;
    }
}
