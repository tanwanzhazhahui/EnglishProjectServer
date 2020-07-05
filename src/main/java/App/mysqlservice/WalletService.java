package App.mysqlservice;

import App.vo.Wallet;

public interface WalletService {
    public void AddWallet(Wallet wallet);
    public void UpdateWallet(Wallet wallet);
    public void DeleteWallet(Wallet wallet);
    public Wallet getWalletByPhonenumber(String phonenumber);
    public void  UpdateTradePasswordByPhonenumber(String phonenumber,String tradepassword);
}
