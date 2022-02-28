package lesson2;

import lesson2.exceptions.MyArrayDataException;
import lesson2.exceptions.MyArraySizeException;

public class Lesson2 {

    public static void main(String[] args) {
        String[][] array = {
                {"1", "2", "3", "4"},
                {"2", "3", "4", "5"},
                {"3", "4", "5", "6"},
                {"4", "5", "6", "7"}
        };
        try {
            computeArray(array);
        }
        catch (MyArraySizeException | MyArrayDataException e) {
            System.out.printf("%s %s%n", e.getClass().getSimpleName(), e.getMessage());
        }
    }

    public static void computeArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array == null || array.length != 4) {
            throw new MyArrayDataException("Не верный размер массива");
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array[i].length; j++) {
                if (array[i].length != 4) {
                    throw new MyArrayDataException("Не верный размер массива");
                }
                try {
                    sum += Integer.parseInt(array[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("Ошибка преобразование в int в ячейке: [%d][%d]", i, j));
                }
            }
        }
        System.out.printf("Результат суммирования: %d", sum);
    }
}
