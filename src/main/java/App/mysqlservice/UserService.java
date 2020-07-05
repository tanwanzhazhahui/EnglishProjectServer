package App.mysqlservice;

import App.vo.User;

public interface UserService {
    public void AddNewUser(User user);
    public void UpdateUser(User user);
    public void DeleteUser(User user);
    public User getUserByPhonenumber(String phonenumber);
    public void UpdateAvatorByPhonenumber(String phonenumber,String avator);
}
