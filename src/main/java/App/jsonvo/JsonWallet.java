package App.jsonvo;

public class JsonWallet {
    private Double money;
    private String tradepassword;

    public JsonWallet(Double money,String tradepassword){
        this.money=money;
        this.tradepassword=tradepassword;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getTradepassword() {
        return tradepassword;
    }

    public void setTradepassword(String tradepassword) {
        this.tradepassword = tradepassword;
    }

}
