package App.jsonvo;

public class JsonUser {
    private String phonenumber;
    private String username;
    private String sex;
    private String email;
    private String avator;

    public JsonUser(String phonenumber,String username,String sex,String email,String avator){
        this.phonenumber=phonenumber;
        this.username=username;
        this.sex=sex;
        this.email=email;
        this.avator=avator;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvator() {
        return avator;
    }

    public void setAvator(String avator) {
        this.avator = avator;
    }

}
