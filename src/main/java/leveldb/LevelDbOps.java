package leveldb;

import org.iq80.leveldb.*;
import static org.fusesource.leveldbjni.JniDBFactory.*;
import java.io.*;

public class LevelDbOps {

    public static void main(String args[]) throws IOException {
        Options options = new Options();
        options.createIfMissing(true);
        DB db = factory.open(new File("target/leveldb"), options);
        DB db2 = factory.open(new File("target/leveldb"), options);
        DBIterator iterator = db.iterator();
        try {
            db.put(bytes("Tampa"), bytes("rocks"));
            String value = asString(db.get(bytes("Tampa")));
            System.out.println(value);
        } finally {
            // Make sure you close the db to shutdown the
            // database and avoid resource leaks.
            db.close();
        }
    }

}
