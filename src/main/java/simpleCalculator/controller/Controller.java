package simpleCalculator.controller;

import simpleCalculator.model.Model;
import simpleCalculator.view.CalcView;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Controller {
    Model model;
    CalcView view;

    Logger logger;

    public Controller(Model model, CalcView view) {
        this.model = model;
        this.view = view;
        this.logger = model.getLogger();
    }

    public void go() {
        try {
            String path = "src/main/java/simpleCalculator/logs/";
            setLogger(path);
            model.getStack().push(1);
            while (model.getStack().peek() != null) {
                if (model.getStack().peek() == 1) {
                    view.startMessage();
                    if (model.checkA(view.prompt(""))) {
                        logger.info(String.format("Ввели число %s", model.getA()));
                    }
                }

                if (model.getStack().peek() == 2) {
                    if (model.checkSign(view.prompt("Какую операцию выполним? (доступны \"+ - * /\"): "))) { //вводим операцию
                        logger.info(String.format("Ввели знак %s", model.getSign()));
                    }
                }

                if (model.getStack().peek() == 3) {
                    if (model.checkB(view.prompt("И теперь введите второе число: \n"), model.getSign())) {
                        logger.info(String.format("Ввели число %s", model.getB()));
                    }
                }
                if (model.getStack().peek() == 4) {
                    String result = String.format("Решаем пример: %s %c %s = %.2f\n", model.getA(), model.getSign(), model.getB(), model.computing());
                    System.out.printf(result);
                    logger.info(result);
                    model.getStack().clear();
                    model.getStack().push(1);
                }
            }
        } catch (NullPointerException ex) {
            logger.info(ex.getMessage());
        }
    }

    private void setLogger(String path) {
        try {
            FileHandler fh = new FileHandler(path + "log.txt");
            logger.addHandler(fh);
            SimpleFormatter sf = new SimpleFormatter();
            fh.setFormatter(sf);
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
    }
}
