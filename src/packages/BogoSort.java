package packages;

import java.util.Random;

public class BogoSort {

    // Метод для проверки, отсортирован ли массив
    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // Метод для случайного перемешивания элементов массива
    public static void shuffle(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int randomIndex = random.nextInt(array.length);
            // Меняем местами текущий элемент с элементом в случайной позиции
            int temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
    }

    // Метод Bogosort
    public static void bogosort(int[] array) {
        // Повторяем пока массив не станет отсортированным
        while (!isSorted(array)) {
            shuffle(array);  // Случайно перемешиваем массив
        }
    }

}