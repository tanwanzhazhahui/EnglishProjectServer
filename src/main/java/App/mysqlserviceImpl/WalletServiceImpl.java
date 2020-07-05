package App.mysqlserviceImpl;

import App.vo.Wallet;
import App.mysqldao.WalletDao;
import App.mysqlservice.WalletService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional(readOnly = false)
@Service("WalletService")
public class WalletServiceImpl implements WalletService {

    @Resource private WalletDao walletDao;

    @Override
    public void AddWallet(Wallet wallet) {
        walletDao.AddWallet(wallet);
    }

    @Override
    public void UpdateWallet(Wallet wallet) {
        walletDao.UpdateWallet(wallet);
    }

    @Override
    public void DeleteWallet(Wallet wallet) {
        walletDao.DeleteWallet(wallet);
    }

    @Override
    public Wallet getWalletByPhonenumber(String phonenumber) {
        return walletDao.getWalletByPhonenumber(phonenumber);
    }

    @Override
    public void UpdateTradePasswordByPhonenumber(String phonenumber, String tradepassword) {
        walletDao.UpdateTradePasswordByPhonenumber(phonenumber,tradepassword);
    }
}
