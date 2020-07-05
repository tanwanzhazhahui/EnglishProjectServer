package App.mysqlserviceImpl;

import App.vo.UsersBooks;
import App.mysqldao.UsersBooksDao;
import App.mysqlservice.UsersBooksService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Set;

@Transactional(readOnly = false)
@Service("UsersBooksService")
public class UsersBooksServiceImpl implements UsersBooksService {

    @Resource private UsersBooksDao usersBooksDao;

    @Override
    public void AddUsersBooks(UsersBooks usersBooks) {
        usersBooksDao.AddUsersBooks(usersBooks);
    }

    @Override
    public void UpdateUsersBooks(UsersBooks usersBooks) {
        usersBooksDao.UpdateUsersBooks(usersBooks);
    }

    @Override
    public void DeleteUsersBooks(UsersBooks usersBooks) {
        usersBooksDao.DeleteUsersBooks(usersBooks);
    }

    @Override
    public Set<UsersBooks> getUsersBooksByPhonenumber(String phonenumber) {
        return usersBooksDao.getUsersBooksByPhonenumber(phonenumber);
    }
}
