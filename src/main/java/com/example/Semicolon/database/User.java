package com.example.Semicolon.database;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

public class User {
    public long id;
    public String username, password, email;

    public User(){}
    public User(String username, String password, String email){
        username = username;
        password = password;
        email = email;
    }
}
