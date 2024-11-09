package packages;

public class Queue {
    private int maxSize; // Максимальный размер очереди
    private int front; // Индекс первого элемента
    private int rear; // Индекс последнего элемента
    private int[] queueArray; // Массив для хранения элементов очереди
    private int currentSize; // Текущий размер очереди

    // Конструктор для создания очереди
    public Queue(int size) {
        maxSize = size;
        queueArray = new int[size];
        front = 0;
        rear = -1;
        currentSize = 0;
    }

    // Метод для добавления элемента в очередь
    public void enqueue(int value) {
        if (currentSize < maxSize) {
            rear = (rear + 1) % maxSize; // Круговая очередь
            queueArray[rear] = value;
            currentSize++;
            System.out.println("Добавлено " + value);
        } else {
            System.out.println("Очередь полна");
        }
    }

    // Метод для удаления элемента из очереди
    public int dequeue() {
        if (currentSize > 0) {
            int dequeuedValue = queueArray[front];
            front = (front + 1) % maxSize; // Круговая очередь
            currentSize--;
            System.out.println("Удален " + dequeuedValue);
            return dequeuedValue;
        } else {
            System.out.println("Очередь пуста");
            return -1; // Очередь пуста
        }
    }

    // Метод для получения первого элемента очереди без удаления
    public int peek() {
        if (currentSize > 0) {
            return queueArray[front];
        } else {
            System.out.println("Очередь пуста");
            return -1; // Очередь пуста
        }
    }

    // Метод для проверки, пуста ли очередь
    public boolean isEmpty() {
        return currentSize == 0;
    }

    // Метод для проверки, полна ли очередь
    public boolean isFull() {
        return currentSize == maxSize;
    }

    // Метод для получения размера очереди
    public int size() {
        return currentSize;
    }
}