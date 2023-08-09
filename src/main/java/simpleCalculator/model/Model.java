package simpleCalculator.model;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Logger;

public class Model {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private Deque<Integer> stack = new ArrayDeque<>();
    private double a;
    private double b;
    private char sign;

    public Deque<Integer> getStack() {
        return stack;
    }

    public void setStack(Deque<Integer> stack) {
        this.stack = stack;
    }

    public Logger getLogger() {
        return logger;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public char getSign() {
        return sign;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setSign(char sign) {
        this.sign = sign;
    }

    public boolean checkA(String s) {
        if (s.equalsIgnoreCase("exit")) {
            logger.info("Выход из программы.");
            stack.clear();
            return false;
        }
        if (isNumber(s)) {
            stack.push(2);
            a = Double.parseDouble(s);
            return true;
        }
        logger.info("Вы ввели не число! Введите число: ");
        return false;
    }

    public boolean checkB(String s, char sign) {
        if (s.equalsIgnoreCase("exit")) {
            logger.info("Выход из программы.");
            stack.clear();
            return false;
        }
        if (s.equalsIgnoreCase("back")) {
            stack.pop();
            logger.info("Отмена операции.");
            return false;
        }
        if (isNumber(s)) {
            b = Double.parseDouble(s);
        } else {
            logger.info("Вы ввели не число! Введите число: ");
            return false;
        }
        if (sign == '/') {
            if (b == 0) {
                logger.info("На ноль делить нельзя! Введите другое число.");
                return false;
            }
        }
        stack.push(4);
        return true;
    }

    public boolean checkSign(String s) {
        if (s.equalsIgnoreCase("exit")) {
            logger.info("Выход из программы.");
            stack.clear();
            return false;
        }
        if (s.equalsIgnoreCase("back")) {
            stack.pop();
            logger.info("Отмена операции.");
            return false;
        }
        sign = s.charAt(0);
        switch (sign) {
            case '+', '-', '/', '*' -> {
                stack.push(3);
                return true;
            }
            default -> {
                logger.info("Введите пожалуйста один из допустимых символов: \"+ - * /\"");
                return false;
            }
        }
    }

    public double computing() {
        switch (sign) {
            case '+' -> {
                return a + b;
            }
            case '-' -> {
                return a - b;
            }
            case '*' -> {
                return a * b;
            }
            case '/' -> {
                return (double) a / b;
            }
            default -> {
                System.out.println("\nчто-то пошло не так");
                return 0;
            }
        }
    }

    private boolean isIntNumber(String s) {  // Проверка на целое число
        return s.matches("[-+]?\\d+");
    }

    private boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
