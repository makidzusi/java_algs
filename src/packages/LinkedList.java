package packages;

// Класс для представления связанного списка
public  class LinkedList {
    LinkedListNode head;  // Голова списка

    // Конструктор списка
    public LinkedList() {
        head = null;
    }

    // Метод для добавления элемента в конец списка
    public void append(int data) {
        LinkedListNode newNode = new LinkedListNode(data);

        // Если список пуст, новый элемент становится головой
        if (head == null) {
            head = newNode;
        } else {
            // Иначе, находим последний элемент и добавляем новый
            LinkedListNode last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
    }

    // Метод для добавления элемента в начало списка
    public void prepend(int data) {
        LinkedListNode newNode = new LinkedListNode(data);
        newNode.next = head;
        head = newNode;
    }

    // Метод для удаления элемента из списка
    public void delete(int key) {
        // Если список пуст, ничего не делаем
        if (head == null) {
            return;
        }

        // Если нужно удалить первый элемент
        if (head.data == key) {
            head = head.next;
            return;
        }

        // Ищем элемент с данным значением и удаляем его
        LinkedListNode current = head;
        while (current.next != null && current.next.data != key) {
            current = current.next;
        }

        // Если элемент найден, удаляем его
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // Метод для поиска элемента в списке
    public boolean search(int key) {
        LinkedListNode current = head;
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Метод для вывода всех элементов списка
    public void printList() {
        LinkedListNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Метод для получения размера списка
    public int size() {
        int count = 0;
        LinkedListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}