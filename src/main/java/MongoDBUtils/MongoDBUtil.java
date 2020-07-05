package MongoDBUtils;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

import java.util.Arrays;
public class MongoDBUtil {
    MongoDatabase mongoDatabase;
    public MongoDatabase getConnection(String DBName){
        MongoCredential credential=MongoCredential.createCredential("root", "EnglishApp", "lwj427".toCharArray());
        MongoClient mongoClient=new MongoClient(new ServerAddress("47.100.92.75",27017), Arrays.asList(credential));
        mongoDatabase=mongoClient.getDatabase(DBName);
        System.out.println("数据连接成功");
        return mongoDatabase;

    }
}
