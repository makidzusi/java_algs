package packages;

public class Set {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    // Конструктор множества
    public Set() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    // Метод для добавления элемента в множество
    public boolean add(Object element) {
        // Проверяем, существует ли уже элемент в множестве
        if (contains(element)) {
            return false; // Если элемент уже существует, не добавляем
        }

        // Если место в массиве закончилось, увеличиваем его размер
        if (size == elements.length) {
            resize();
        }

        elements[size++] = element;
        return true;
    }

    // Метод для удаления элемента из множества
    public boolean remove(Object element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                // Сдвигаем элементы влево, чтобы заполнить пустое место
                for (int j = i; j < size - 1; j++) {
                    elements[j] = elements[j + 1];
                }
                elements[--size] = null; // Убираем последний элемент
                return true;
            }
        }
        return false; // Если элемент не найден, возвращаем false
    }

    // Метод для проверки, содержится ли элемент в множестве
    public boolean contains(Object element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    // Метод для получения размера множества
    public int size() {
        return size;
    }

    // Метод для проверки, пусто ли множество
    public boolean isEmpty() {
        return size == 0;
    }

    // Метод для вывода всех элементов множества
    public void printSet() {
        if (isEmpty()) {
            System.out.println("Множество пусто.");
        } else {
            System.out.print("{ ");
            for (int i = 0; i < size; i++) {
                System.out.print(elements[i] + " ");
            }
            System.out.println("}");
        }
    }

    // Увеличение размера массива, когда место заканчивается
    private void resize() {
        Object[] newElements = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
    }
}