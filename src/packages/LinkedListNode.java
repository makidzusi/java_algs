package packages;

// Класс для представления узла связанного списка
public class LinkedListNode {
    int data;  // Данные узла
    LinkedListNode next;  // Ссылка на следующий узел

    // Конструктор узла
    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}