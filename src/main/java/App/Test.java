package App;


import App.mysqldao.*;
import App.mysqldaoImpl.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import javax.naming.NamingException;
import java.sql.SQLException;


public class Test {

    public static UserDao userDao=new UserDaolmpl();
    public static BookDao bookDao=new BookDaoImpl();
    public static StudyPlanDao studyplanDao=new StudyPlanDaoImpl();
    public static WordDao wordDao=new WordDaoImpl();
    public static void main(String[] args) throws SQLException ,NamingException {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("ApplicationContext.xml");

    }

}
