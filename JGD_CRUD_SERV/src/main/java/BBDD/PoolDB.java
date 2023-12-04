package BBDD;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class PoolDB {

    static final Logger log = LoggerFactory.getLogger(PoolDB.class);

    public DataSource dataSource;

    public PoolDB() {
        initDataSource();
    }

    private void initDataSource() {
        Properties properties = new Properties();

        try {
            properties.load(
                    Thread.currentThread()
                            .getContextClassLoader()
                            .getResourceAsStream("bd.properties"));
            log.info("Properties loaded");
        } catch (IOException e) {
            e.printStackTrace();
        }

        BasicDataSource basicDataSource = new BasicDataSource();

        basicDataSource.setDriverClassName(properties.getProperty("classForName"));
        basicDataSource.setUsername(properties.getProperty("user"));
        basicDataSource.setPassword(properties.getProperty("password"));

        log.info("ClassName" + basicDataSource.getDriverClassName() +
                "User: "+basicDataSource.getUsername() +
                "Password " + basicDataSource.getPassword());

        String url =
                properties.getProperty("url") + "//" + properties.getProperty("server")+ ":"+
                        properties.getProperty("port") + "/" + properties.getProperty("db");

        log.info("URL : " + url);

        basicDataSource.setUrl(url);
        basicDataSource.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));
        basicDataSource.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal")));

        dataSource = basicDataSource;
    }

    public Connection getConnection(){
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException s) {
            log.error(s.toString());
        }

        return connection;
    }
}
