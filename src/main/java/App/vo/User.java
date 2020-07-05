package App.vo;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable{
    private int userid;
    private String phonenumber;
    private String username;
    private String sex;
    private String email;
    private String avator;

    private String password;//mongo中的密码
    private Wallet wallet;
    private Set<UsersBooks> usersbooks=new HashSet<UsersBooks>();

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Set<UsersBooks> getUsersbooks() {
        return usersbooks;
    }

    public void setUsersbooks(Set<UsersBooks> usersbooks) {
        this.usersbooks = usersbooks;
    }


}
