package packages;

public class Stack {
    private final int maxSize; // Максимальный размер стека
    private int top; // Индекс верхнего элемента стека
    private final int[] stackArray; // Массив для хранения элементов стека

    // Конструктор для создания стека
    public Stack(int size) {
        maxSize = size;
        stackArray = new int[size];
        top = -1; // Стек пуст, поэтому top = -1
    }

    // Метод для добавления элемента в стек
    public void push(int value) {
        if (top < maxSize - 1) {
            stackArray[++top] = value; // Увеличиваем top и добавляем элемент
            System.out.println("Добавлен " + value);
        } else {
            System.out.println("Стэк полон");
        }
    }

    // Метод для удаления элемента из стека
    public int pop() {
        if (top >= 0) {
            int poppedValue = stackArray[top--]; // Возвращаем верхний элемент и уменьшаем top
            System.out.println("Удален " + poppedValue);
            return poppedValue;
        } else {
            System.out.println("Стэк пуст");
            return -1; // Стек пуст
        }
    }

    // Метод для получения верхнего элемента стека без удаления
    public int peek() {
        if (top >= 0) {
            return stackArray[top]; // Возвращаем верхний элемент
        } else {
            System.out.println("Стэк пуст");
            return -1; // Стек пуст
        }
    }

    // Метод для проверки, пуст ли стек
    public boolean isEmpty() {
        return top == -1;
    }

    // Метод для проверки, полный ли стек
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // Метод для получения размера стека
    public int size() {
        return top + 1;
    }
}