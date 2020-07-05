package MongoDBUtils;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class TestConnection {
    public static MongoDBUtil mongoDBUtil;
    public static MongoDatabase mongoDatabase;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        mongoDBUtil=new MongoDBUtil();
        mongoDatabase=mongoDBUtil.getConnection("EnglishApp");
        MongoCollection<Document> collection=mongoDatabase.getCollection("user");

        FindIterable<Document> findIterable=collection.find();
        MongoCursor<Document> mongoCursor=findIterable.iterator();
        while(mongoCursor.hasNext()){
            System.out.println(mongoCursor.next());
        }
    }
}
