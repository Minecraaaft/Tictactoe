package controller;

import model.Logic;
import view.Component;

public class Controller {
    private Component component;

    public Controller(Component component) {
        this.component = component;
    }

    public void playGame() {
        component.start();
    }

}
