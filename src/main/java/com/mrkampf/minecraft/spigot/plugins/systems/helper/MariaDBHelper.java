package com.mrkampf.minecraft.spigot.plugins.systems.helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class MariaDBHelper {

    private final String host, database, user, password;
    private int port = 3306;

    Connection connection;

    public MariaDBHelper(String host, String database, String user, String password) {
        this.host = host;
        this.database = database;
        this.user = user;
        this.password = password;
        this.conn();
    }


    public MariaDBHelper(String host, String database, String user, String password, Integer port) {
        this.host = host;
        this.database = database;
        this.user = user;
        this.password = password;
        this.port = port;
        this.conn();
    }

    private Connection conn() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mariadb://" + host + ":" + port + "/" + database + "?autoReconnect=true",
                    user, password
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }


    public Connection getConnection() {
        return connection;
    }

    public boolean isConnected() {
        return connection != null;
    }

    public void reconnect() {
        this.conn();
    }
}
