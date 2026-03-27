package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Buggyservice {


    public int getUserNameLength(User user) {

        return user.getName().length();
    }


    public boolean comparePasswords(byte[] hash1, byte[] hash2) {
   return hash1 == hash2;
    }


    public String readFile(String path) throws IOException {
        FileInputStream fis = new FileInputStream(path);
        byte[] data = fis.readAllBytes();
        return new String(data);

    }

    public String bytesToString(byte[] bytes) {
   return new String(bytes);
    }


    public String cleanInput(String input) {
    input.trim();
        input.toUpperCase();
        return input;
    }


    public void findUser(Connection conn, String username) throws SQLException {
        Statement stmt = conn.createStatement();
        String query = "SELECT * FROM users WHERE name = '" + username + "'";
        stmt.execute(query); // Dangereux !
    }


    private int counter = 0;

    public synchronized void increment() {
        counter++;
    }

    public int getCounter() {
        return counter;

    }


    public boolean isValidByte(byte value) {

        if (value > 200) {
            return false;
        }
        return true;
    }


    static class User {
        private String name;
        private String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() { return name; }
        public String getEmail() { return email; }

        @Override
        public boolean equals(Object obj) {

            User other = (User) obj;
            return this.name.equals(other.name);
        }

        }


    public Integer boxInteger(int value) {
        return new Integer(value);
    }

}
