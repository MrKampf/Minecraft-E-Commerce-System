package com.mrkampf.minecraft.spigot.plugins.systems.helper;

public class DatabaseManager {

    private final String host, database, user, password;
    private int port = 3306;

    private MariaDBHelper mariaDBHelper;

    public DatabaseManager(String host, String database, String user, String password) {
        this.host = host;
        this.database = database;
        this.user = user;
        this.password = password;
    }

    public DatabaseManager(String host, String database, String user, String password, Integer port) {
        this.host = host;
        this.database = database;
        this.user = user;
        this.password = password;
        this.port = port;
    }

    public void connect(String type) {
        if (type.equalsIgnoreCase("mariadb")) {
            this.connectMariaDB();
        }
    }

    public void connectMariaDB() {
        mariaDBHelper = new MariaDBHelper(host, database, user, password, port);
        if (mariaDBHelper.isConnected()) {
            System.out.println("MariaDB connected!");
        } else {
            System.out.println("MariaDB not connected!");
        }
    }

    public void closeMariaDB() {
        mariaDBHelper.close();
    }

    public MariaDBHelper getMariaDBHelper() {
        return mariaDBHelper;
    }
}
