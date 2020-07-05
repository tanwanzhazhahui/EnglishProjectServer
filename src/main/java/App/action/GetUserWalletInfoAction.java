package App.action;

import App.jsonvo.JsonWallet;
import App.vo.Wallet;
import App.mysqlservice.WalletService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

@Controller
@Scope("prototype")
public class GetUserWalletInfoAction extends ActionSupport {
    //将会被Struts2序列化为JSON字符串的对象
    private Map<String, Object> dataMap;

    private String phonenumber;//获得服务器送来的phonenumber
    private String param;//请求参数

    public ApplicationContext ctx=new ClassPathXmlApplicationContext("ApplicationContext.xml");
    public WalletService walletService=(WalletService)ctx.getBean("WalletService");
    @Override
    public String execute() throws Exception {
        if(param.equals("8a68acd94ca0743ebea2dccce11788c4")){
            dataMap=new HashMap<String, Object>();
            Wallet wallet=walletService.getWalletByPhonenumber(phonenumber);
            JsonWallet jsonWallet=new JsonWallet(wallet.getMoney(),wallet.getTradepassword());
            dataMap.put("userwallet",jsonWallet);
            return SUCCESS;
        }else {
            return INPUT;
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

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

}
