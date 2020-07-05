package App.mongodao;

import MongoDBUtils.MongoDBUtil;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class LoginDao {
    public static MongoDBUtil mongoDBUtil;
    public static MongoDatabase mongoDatabase;

    public static MongoCursor<Document> FindUser(String phonenumber){
        mongoDBUtil=new MongoDBUtil();
        mongoDatabase=mongoDBUtil.getConnection("EnglishApp");
        MongoCollection<Document> collection=mongoDatabase.getCollection("user");
        Document whereQuery=new Document();
        whereQuery.put("phonenumber", phonenumber);
        FindIterable<Document> findIterable=collection.find(whereQuery);
        MongoCursor<Document> mongoCursor=findIterable.iterator();
        return mongoCursor;
    }

    public static boolean AddUser(String phonenumber,String password){
        mongoDBUtil=new MongoDBUtil();
        mongoDatabase=mongoDBUtil.getConnection("EnglishApp");
        MongoCollection<Document> collection=mongoDatabase.getCollection("user");
        Document document=new Document("phonenumber",phonenumber).append("password", password);
        collection.insertOne(document);
        return true;
    }

    public static boolean UpdateUserPassword(String phonenumber,String newpassword){
        mongoDBUtil=new MongoDBUtil();
        mongoDatabase=mongoDBUtil.getConnection("EnglishApp");
        MongoCollection<Document> collection=mongoDatabase.getCollection("user");
        collection.updateOne(Filters.eq("phonenumber", phonenumber), new Document("$set",new Document("password",newpassword)));
        return true;
    }
}
