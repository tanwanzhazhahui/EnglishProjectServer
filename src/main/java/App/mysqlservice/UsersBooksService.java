package App.mysqlservice;

import App.vo.UsersBooks;

import java.util.Set;

public interface UsersBooksService {
    public void AddUsersBooks(UsersBooks usersBooks);
    public void UpdateUsersBooks(UsersBooks usersBooks);
    public void DeleteUsersBooks(UsersBooks usersBooks);
    public Set<UsersBooks> getUsersBooksByPhonenumber(String phonenumber);
}
