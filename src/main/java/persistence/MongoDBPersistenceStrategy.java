package persistence;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import entities.HighScore;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class MongoDBPersistenceStrategy implements PersistenceStrategy {

    private DBCollection collection;

    public MongoDBPersistenceStrategy(String url) {
        try {
            MongoClient client = new MongoClient(url);
            this.collection = client.getDB("HighScore").getCollection("scores");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public void persist(int score) {


    }

    public void load() {
        DBCursor cursor = this.collection.find();
        List<Integer> scores = new ArrayList<>();
        while (cursor.hasNext()) {
            scores.add((Integer) cursor.one().get("score"));
            cursor.next();
        }
        HighScore.getInstance().setScores(scores);
    }
}
