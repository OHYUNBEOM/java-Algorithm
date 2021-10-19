package pagemaker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Database {
    private Database() {    // new로 인스턴스를 생성시키지 않기 위해 private 선언
    }
    public static Properties getProperties(String dbname) { // 데이터베이스명으로부터 Properties를 얻는다.
        String filename = dbname + ".txt";
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(filename));
        } catch (IOException e) {
            System.out.println("Warning: " + filename + " is not found.");
        }
        return prop;
    }
}
