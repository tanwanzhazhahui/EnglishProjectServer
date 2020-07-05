package App.mysqldao;

import App.vo.UsersBooks;

import java.util.Set;

public interface UsersBooksDao {
    public void AddUsersBooks(UsersBooks usersBooks);
    public void UpdateUsersBooks(UsersBooks usersBooks);
    public void DeleteUsersBooks(UsersBooks usersBooks);
    public Set<UsersBooks> getUsersBooksByPhonenumber(String phonenumber);
}
