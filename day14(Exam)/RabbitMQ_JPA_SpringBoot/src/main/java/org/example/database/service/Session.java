package org.example.database.service;

import com.google.gson.Gson;
import org.example.database.model.User;

import java.util.List;

public class Session {
    private boolean LoggedIn;
    private String account_number;

    public Session(String account_number){
        setLoggedIn(true);
        setAccount_number(account_number);
    }



    public boolean isLoggedIn() {
        return LoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        LoggedIn = loggedIn;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }
}
