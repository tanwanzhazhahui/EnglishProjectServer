package MysqlUtils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) throws SQLException {
        // TODO Auto-generated method stub
        DataSource dataSource=new ComboPooledDataSource();
        System.out.println(dataSource.getConnection());

    }
}
