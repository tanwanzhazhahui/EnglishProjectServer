package App.action;

import App.vo.User;
import App.vo.Wallet;
import App.mysqlservice.UserService;
import App.mysqlservice.WalletService;
import MongoDBUtils.MD5Utils;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
@Scope("prototype")
public class ChangeUserInfoAction extends ActionSupport {
    //将会被Struts2序列化为JSON字符串的对象
    private Map<String, Object> dataMap;

    private String phonenumber;//获得服务器送来的值
    private String username;
    private String sex;
    private String email;
    private String tradepassword;
    private String param;//请求参数


    public ApplicationContext ctx=new ClassPathXmlApplicationContext("ApplicationContext.xml");
    public UserService userService=(UserService)ctx.getBean("userservice");
    public WalletService walletService=(WalletService)ctx.getBean("WalletService");

    @Override
    public String execute() throws Exception {
        if(param.equals("8a68acd94ca0743ebea2dccce11788c4")){
            User user=userService.getUserByPhonenumber(phonenumber);
            Wallet wallet=walletService.getWalletByPhonenumber(phonenumber);
            switch (getType(username,sex,email,tradepassword)){
                case "修改昵称":
                    user.setUsername(username);
                    userService.UpdateUser(user);
                    break;
                case "修改性别":
                    user.setSex(sex);
                    userService.UpdateUser(user);
                    break;
                case "修改邮箱":
                    user.setEmail(email);
                    userService.UpdateUser(user);
                    break;
                case "设置交易密码":
                    String safetradepassword=MD5Utils.md5Password(tradepassword+"我人裂开了");
                    wallet.setTradepassword(safetradepassword);
                    walletService.UpdateWallet(wallet);
                    break;
                case "非法请求":
                    break;
            }
            return SUCCESS;
        }else {
            return INPUT;
        }
    }

    public String getType(String username,String sex,String email,String tradepassword){
        if (username!=null){
            return "修改昵称";
        }else if(sex!=null){
            return "修改性别";
        }else if(email!=null){
            return "修改邮箱";
        }else if(tradepassword!=null){
            return "设置交易密码";
        }else{
            return "非法请求";
        }
    }



    public Map<String, Object> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, Object> dataMap) {
        this.dataMap = dataMap;
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

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getTradepassword() {
        return tradepassword;
    }

    public void setTradepassword(String tradepassword) {
        this.tradepassword = tradepassword;
    }
}
