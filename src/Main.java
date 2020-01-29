import controller.Controller;
import model.Logic;
import view.Component;

public class Main {
    public static void main(String[] args) {
        Logic logic = new Logic();
        Component component = new Component(logic);

        new Controller(component).playGame();
    }
}
