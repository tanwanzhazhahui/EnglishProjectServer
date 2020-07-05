package App.vo;

public class UsersBooks {

    private Integer ubid;
    private Integer userid;
    private Integer bid;
    private Integer finishphrase;
    private String deadline;

    private Book book;
    private StudyPlan studyplan;
    private User user;


    public Integer getUbid() {
        return ubid;
    }

    public void setUbid(Integer ubid) {
        this.ubid = ubid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getFinishphrase() {
        return finishphrase;
    }

    public void setFinishphrase(Integer finishphrase) {
        this.finishphrase = finishphrase;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }


    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public StudyPlan getStudyplan() {
        return studyplan;
    }

    public void setStudyplan(StudyPlan studyplan) {
        this.studyplan = studyplan;
    }


}
