package jm.task.core.jdbc.util;

import org.hibernate.Session;
import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.*;

public class Util {
    private final static String URL = "jdbc:mysql://localhost:3306/testbyafanta";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "567tesla765";

    public static Connection getConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("OK");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static Session getConfiguration() {
        Configuration configuration = new Configuration().addAnnotatedClass(User.class);
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url", URL);
        configuration.setProperty("hibernate.connection.username", USERNAME);
        configuration.setProperty("hibernate.connection.password", PASSWORD);
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        System.out.println("OK");
        return session;
    }
}