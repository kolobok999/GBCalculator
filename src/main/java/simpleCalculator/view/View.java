package simpleCalculator.view;

import java.util.Scanner;

public class View implements CalcView {
    @Override
    public String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    @Override
    public void startMessage() {
        System.out.println("""

                Вас приветствует калькулятор!
                Я могу выполнить 4 простейшие операции, это сложение, вычитание, умножение, деление.
                Для отмены операции введите "back"
                Для выхода из программы введите "exit"
                Для начала определимся с цифрами. Введите первое число:""");
    }
}
