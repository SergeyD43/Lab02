package utils;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class SingletonDBConnection {

    private static final Logger logger = Logger.getLogger(SingletonDBConnection.class);

    private static SingletonDBConnection instance;
    public static SingletonDBConnection getInstance(){
        if(instance == null) {
            instance = new SingletonDBConnection();
        }
        return instance;
    }

    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/school";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    private Connection connection;

    public Connection connect() {
        if (connection == null) {
            try {
                Class.forName(DATABASE_DRIVER);
                try {
                    connection = DriverManager.getConnection(DATABASE_URL,USERNAME, PASSWORD);
                    logger.info("Соедиение с базой данных установлено");
                } catch (SQLException e) {
                    logger.fatal("Не удалось установить соединение с базой данных");
                }
            } catch (ClassNotFoundException e) {
                logger.fatal("Отсутствует драйвер базы данных");
            }
        }
        return connection;
    }
}
