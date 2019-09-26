package com.dating.server.Features;

public class Features {

    private static Features instance = new Features();




    private Features() {
    }

    public static Features getInstance() {
        return instance;
    }
}
