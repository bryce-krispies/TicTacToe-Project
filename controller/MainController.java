package controller;

import view.MainMenu;
import model.Board;

public class MainController {

    private Board board;

    public MainController() {
        new MainMenu(this);
    }

    public static void main(String[] args) {
        new MainController();
    }
}
