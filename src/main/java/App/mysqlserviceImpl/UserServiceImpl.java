package App.mysqlserviceImpl;

import App.vo.User;
import App.mysqldao.UserDao;
import App.mysqlservice.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional(readOnly = false)
@Service("userservice")
public class UserServiceImpl implements UserService {

    @Resource private UserDao userDao;

    @Override
    public void AddNewUser(User user) {
        userDao.AddNewUser(user);
    }

    @Override
    public void UpdateUser(User user) {
        userDao.UpdateUser(user);
    }

    @Override
    public void DeleteUser(User user) {
        userDao.DeleteUser(user);
    }

    @Override
    public User getUserByPhonenumber(String phonenumber) {
        return userDao.getUserByPhonenumber(phonenumber);
    }

    @Override
    public void UpdateAvatorByPhonenumber(String phonenumber, String avator) {
        userDao.UpdateAvatorByPhonenumber(phonenumber,avator);
    }
}
