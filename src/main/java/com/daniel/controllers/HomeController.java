package com.daniel.controllers;

import com.daniel.views.HomeView;

public class HomeController {

    public HomeController() {
        index()
    }

    public void index() {
        HomeView.printMenu();
    }
}
