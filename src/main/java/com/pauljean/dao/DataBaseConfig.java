package com.pauljean.dao;

import io.vertx.core.json.JsonObject;

public class DataBaseConfig implements Cloneable{

    private String host;
    private Integer port;
    private String user;
    private String password;
    private String database;

    public static final JsonObject DEFAULT_DATABASE_CONFIG = new JsonObject()
            .put("host","localhost")
            .put("port",5432)
            .put("user","postgres")
            .put("password","admin")
            .put("database","postgres");


    public static DataBaseConfig create(JsonObject config) {
        DataBaseConfig configuration = new DataBaseConfig();

        JsonObject databaseConfig = config.getJsonObject("database", DEFAULT_DATABASE_CONFIG);
        configuration
                .withHost(databaseConfig.getString("host", DEFAULT_DATABASE_CONFIG.getString("host")))
                .withPort(databaseConfig.getInteger("port", DEFAULT_DATABASE_CONFIG.getInteger("port")))
                .withUser(databaseConfig.getString("user", DEFAULT_DATABASE_CONFIG.getString("user")))
                .withPassword(databaseConfig.getString("password", DEFAULT_DATABASE_CONFIG.getString("password")))
                .withDatabase(databaseConfig.getString("database", DEFAULT_DATABASE_CONFIG.getString("database")));

        return configuration;
    }

    public String getHost() {
        return host;
    }

    public String getPassword() {
        return password;
    }

    public String getDatabase() {
        return database;
    }

    public String getUser() {
        return user;
    }

    public Integer getPort() {
        return port;
    }

    public DataBaseConfig withHost(String host) {
        this.host = host;
        return this;
    }

    public DataBaseConfig withPort(Integer port) {
        this.port = port;
        return this;
    }

    public DataBaseConfig withUser(String user) {
        this.user = user;
        return this;
    }

    public DataBaseConfig withDatabase(String database) {
        this.database = database;
        return this;
    }

    public DataBaseConfig withPassword(String password) {
        this.password = password;
        return this;
    }

    public String connectionUrl() {
        return  String.format("jdbc:postgresql://%s:%d/%s",
                host,
                port,
                database);
    }

    public DataBaseConfig clone() {

        DataBaseConfig configuration = new DataBaseConfig()
                .withDatabase(this.database)
                .withHost(this.host)
                .withPassword(this.password)
                .withPort(this.port)
                .withUser(this.user);
        return configuration;
    }


}
