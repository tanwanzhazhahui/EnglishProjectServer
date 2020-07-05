package App.action;

import App.vo.User;
import App.vo.Wallet;
import App.mongodao.LoginDao;
import App.mysqlservice.UserService;
import App.mysqlservice.WalletService;
import MongoDBUtils.MD5Utils;
import com.mongodb.client.MongoCursor;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.bson.Document;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

@Controller
@Scope("prototype")
public class LoginAction extends ActionSupport implements ModelDriven {

    public User user=new User();
    public LoginDao loginDao=new LoginDao();

    public ApplicationContext ctx=new ClassPathXmlApplicationContext("ApplicationContext.xml");
    public UserService userService=(UserService)ctx.getBean("userservice");
    public WalletService walletService=(WalletService)ctx.getBean("WalletService");

    @Override
    public Object getModel() {
        return user;
    }

    @Override
    public String execute() throws Exception {
        return super.execute();
    }

    public void checklogin() throws IOException{
        HttpServletRequest request= ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
        try {
            response.setContentType("text/html;charset=utf-8");
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            PrintWriter out = response.getWriter();
            String phonenumber=request.getParameter("phonenumber");
            String password=request.getParameter("password");
            if (request.getParameter("param").equals("8a68acd94ca0743ebea2dccce11788c4")){
                MongoCursor<Document> mongoCursor=loginDao.FindUser(phonenumber);
                try {
                    if(password.equals(mongoCursor.next().get("password").toString())){
                        out.print("登录成功");
                    }else{
                        out.print("账号或密码错误");
                    }
                }catch (NoSuchElementException e){
                    out.print("没有这个用户");
                }
                mongoCursor.close();
            }else {
                response.sendRedirect("http://47.100.92.75:8080/EnglishProject/");
            }
        } catch (Exception e)  {
            response.sendRedirect("http://47.100.92.75:8080/EnglishProject/");
        }

    }

    public void checkregisterd() throws IOException{
        HttpServletRequest request=ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
        try {
            response.setContentType("text/html;charset=utf-8");
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            PrintWriter out = response.getWriter();
            String phonenumber=request.getParameter("phonenumber");
            String password=request.getParameter("password");
            if (request.getParameter("param").equals("8a68acd94ca0743ebea2dccce11788c4")){
                MongoCursor<Document> mongoCursor=loginDao.FindUser(phonenumber);
                try {
                    String pn=mongoCursor.next().getString("phonenumber");
                    //抛出异常下面代码不执行
                    out.print("该手机号已经注册过了");
                }catch (NoSuchElementException e){
                    Boolean addusertomongo=loginDao.AddUser(phonenumber,password);
                    User user=new User();
                    user.setPhonenumber(phonenumber);
                    userService.AddNewUser(user);
                    if(addusertomongo){
                        out.print("注册成功");
                    }
                }
            }else{
                response.sendRedirect("http://47.100.92.75:8080/EnglishProject/");
            }
        } catch (Exception e) {
            response.sendRedirect("http://47.100.92.75:8080/EnglishProject/");
        }

    }


    public void changepassword() throws IOException{
        HttpServletRequest request=ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
        try {
            response.setContentType("text/html;charset=utf-8");
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            PrintWriter out = response.getWriter();
            String phonenumber=request.getParameter("phonenumber");
            String password=request.getParameter("password");
            if (request.getParameter("param").equals("8a68acd94ca0743ebea2dccce11788c4")){
                MongoCursor<Document> mongoCursor=loginDao.FindUser(phonenumber);
                try {
                    String pwd=mongoCursor.next().getString("password");
                    //若抛出异常，下面代码不执行，若没则更新
                    Boolean changepwd=loginDao.UpdateUserPassword(phonenumber,password);
                    if(changepwd){
                        out.print("更改成功");
                    }
                }catch (NoSuchElementException e){
                    e.printStackTrace();
                    out.print("此手机没有注册记录");
                }
            }else{
                response.sendRedirect("http://47.100.92.75:8080/EnglishProject/");
            }
        } catch (Exception e) {
            response.sendRedirect("http://47.100.92.75:8080/EnglishProject/");
        }
    }

    public void checktradepassword() throws Exception{
        HttpServletRequest request=ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
        try {
            response.setContentType("text/html;charset=utf-8");
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            PrintWriter out = response.getWriter();
            String phonenumber=request.getParameter("phonenumber");
            String tradepassword=request.getParameter("tradepassword");
            if (request.getParameter("param").equals("8a68acd94ca0743ebea2dccce11788c4")){
                Wallet wallet=walletService.getWalletByPhonenumber(phonenumber);
                String password=MD5Utils.md5Password(tradepassword+"我人裂开了");
                if (password.equals(wallet.getTradepassword())){
                    out.print("验证成功");
                }else{
                    out.print("验证失败");
                }
            }else{
                response.sendRedirect("http://47.100.92.75:8080/EnglishProject/");
            }
        } catch (Exception e) {
            response.sendRedirect("http://47.100.92.75:8080/EnglishProject/");
        }
    }

}
