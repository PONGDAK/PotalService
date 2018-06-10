import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnectionTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MysqlConnectionTest.class);
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/spring?characterEncoding=utf-8";
    private static final String USER = "spring";
    private static final String PW = "1234";

    @Test
    public void getConnectionTest() throws ClassNotFoundException {
        Class.forName(DRIVER);
        try(Connection conn = DriverManager.getConnection(URL, USER, PW)){ //try with resource 이용 AutoClose
            LOGGER.info("DB 연결됨");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
