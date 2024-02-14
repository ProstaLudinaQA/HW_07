package HW;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Andrii_HW4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введення даних з клавіатури і розміщення їх у списку
        List<String> inputList = new ArrayList<>();
        System.out.println("Введіть перше число:");
        inputList.add(scanner.nextLine());
        System.out.println("Введіть операцію (PLUS, MINUS, MULTIPLICATION, DIVISION, REMAINDER):");
        inputList.add(scanner.nextLine());
        System.out.println("Введіть друге число:");
        inputList.add(scanner.nextLine());

        // Виклик функції calculate та виведення результату
        Integer result = calculate(inputList);
        if (result != null) {
            System.out.println("Результат: " + result);
        } else {
            System.out.println("Неможливо виконати операцію.");
        }
    }

    // Функція для обчислення результату операції
    public static Integer calculate(List<String> inputList) {
        // Перевірка на коректність розміру списку
        if (inputList.size() != 3) {
            return null;
        }

        // Розпакування даних зі списку
        int operand1;
        try {
            operand1 = Integer.parseInt(inputList.get(0));
        } catch (NumberFormatException e) {
            return null;
        }

        Operation operation;
        try {
            operation = Operation.valueOf(inputList.get(1));
        } catch (IllegalArgumentException e) {
            return null;
        }

        int operand2;
        try {
            operand2 = Integer.parseInt(inputList.get(2));
        } catch (NumberFormatException e) {
            return null;
        }

        // Обчислення результату за допомогою switch
        switch (operation) {
            case PLUS:
                return operand1 + operand2;
            case MINUS:
                return operand1 - operand2;
            case MULTIPLICATION:
                return operand1 * operand2;
            case DIVISION:
                // Перевірка на ділення на 0
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    return null;
                }
            case REMAINDER:
                // Перевірка на ділення на 0
                if (operand2 != 0) {
                    return operand1 % operand2;
                } else {
                    return null;
                }
            default:
                return null;
        }
    }
}

