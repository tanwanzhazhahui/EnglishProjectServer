package App.mysqldaoImpl;


import App.vo.User;
import App.vo.Wallet;
import App.mysqldao.UserDao;
import App.mysqldao.WalletDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class WalletDaolmpl extends HibernateDaoSupport implements WalletDao {
    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }

    @Resource private UserDao userDao;

    @Override
    public void AddWallet(Wallet wallet) {
        getHibernateTemplate().save(wallet);
    }

    @Override
    public void UpdateWallet(Wallet wallet) {
        getHibernateTemplate().update(wallet);
    }

    @Override
    public void DeleteWallet(Wallet wallet) {
        getHibernateTemplate().delete(wallet);
    }

    @Override
    public Wallet getWalletByPhonenumber(String phonenumber) {
        User user=userDao.getUserByPhonenumber(phonenumber);
        Wallet wallet=user.getWallet();
        return wallet;
    }

    @Override
    public void UpdateTradePasswordByPhonenumber(String phonenumber, String tradepassword) {
        Wallet wallet=getWalletByPhonenumber(phonenumber);
        wallet.setTradepassword(tradepassword);
        getHibernateTemplate().update(wallet);
    }


}
