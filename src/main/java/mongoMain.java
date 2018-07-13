import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public class mongoMain {
    public static void main(String[] args){

        try {
            MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));


            DB databasename = mongoClient.getDB("databasname");
           DBCollection testcollection = databasename.getCollection("testcollection");
            List<Integer> books = Arrays.asList(27464, 747854);

            DBObject person = new BasicDBObject("_id", "jo")
                    .append("name", "Jo Bloggs")
                    .append("address", new BasicDBObject("street", "123 Fake St")
                            .append("city", "Faketon")
                            .append("state", "MA")
                            .append("zip", 12345))
                    .append("books", books);

testcollection.insert(person);

//mongoClient.dropDatabase("databasname");

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

}
