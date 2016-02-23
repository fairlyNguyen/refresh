package com.example.fairlynguyen.demoproject;

import java.util.Observable;

/**
 * Created by fairlyNGUYEN on 2/23/2016.
 */
public class BaseAppObserver extends Observable {
    public static String MESSAGE_UPDATE_KEY = "update_text";
    public static String MESSAGE_RELOAD_KEY = "reload_text";
    public static String MESSAGE_RELOAD_ALL = "load_all";

    public String getMeesage() {
        return meesage;
    }

    public void setMeesage(String meesage) {
        this.meesage = meesage;
    }

    private String meesage;
    private String value;

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * the value to set
     */
    public void setValue(String name) {
        this.value = name;
        setChanged();
        notifyObservers();
    }
}
