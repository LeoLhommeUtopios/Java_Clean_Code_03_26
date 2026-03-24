package org.example.SOLID.dip;

public interface Database {
    void connect();
}

class MySQLDatabase implements Database {
    @Override
    public void connect() {
        System.out.println("Connection MYSQL");
    }
}
class PostgreDatabase implements Database {
    @Override
    public void connect() {
        System.out.println("Connection Postgres");
    }
}

class UserRepository{
    private Database db;
    public UserRepository(Database db){
        this.db = db;
    }
    public void saveUser(){
        db.connect();
        System.out.println("Sauvegarde de l'utilisateur");
    }
}

