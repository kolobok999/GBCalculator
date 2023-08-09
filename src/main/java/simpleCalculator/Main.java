package simpleCalculator;

import simpleCalculator.controller.Controller;
import simpleCalculator.model.Model;
import simpleCalculator.view.View;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        controller.go();
    }
}
