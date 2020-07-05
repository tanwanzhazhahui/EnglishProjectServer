package MysqlUtils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCUtils {
    private static ThreadLocal<Connection> threadLocal=new ThreadLocal<Connection>();
    private static DataSource ds=new ComboPooledDataSource();
    public static DataSource getDataSource(){
        return ds;
    }
    public static DataSource getDataSource(String str) throws NamingException {
        Context ctx=new InitialContext();
        DataSource ds=(DataSource)ctx.lookup(str);
        return ds;
    }
    public static Connection getConnection() throws SQLException {
        Connection conn=threadLocal.get();
        if(conn==null){
            conn=ds.getConnection();
            threadLocal.set(conn);
        }
        return conn;

    }

    public static void startTransaction() throws SQLException{
        Connection conn=getConnection();
        conn.setAutoCommit(false);
    }

    public static void commit() throws SQLException{
        Connection conn=threadLocal.get();
        if(conn!=null){
            conn.commit();
        }
    }

    public static void rollback() throws SQLException{
        Connection conn=threadLocal.get();
        if(conn!=null){
            conn.rollback();
        }
    }

    public static void close() throws SQLException{
        Connection conn=threadLocal.get();
        try {
            if (conn != null) {
                conn.close();
            }
        } finally{
            threadLocal.remove();
            conn=null;
        }
    }
}
