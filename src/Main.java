import packages.*;

import java.util.Arrays;
import java.util.Scanner;

import static packages.BogoSort.bogosort;

public class Main {

    public static void main(String[] args) {

        String[] options = {
                "1. Проверить стэк",
                "2. Проверить очередь",
                "3. Проверить дерево",
                "4. Проверить дерево с произв.кол-вом потомков",
                "5. Проверить список",
                "6. Проверить множество",
                "7. Лучшая в мире сортировка"
        };

        // Выводим список вариантов
        System.out.println("Выберите вариант:");
        for (String option : options) {
            System.out.println(option);
        }

        // Создаем объект Scanner для ввода данных
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем у пользователя ввод цифры
        System.out.print("Введите номер пункта: ");
        int choice = scanner.nextInt();  // Чтение числа, выбранного пользователем

        // Проверяем введенную цифру и выводим соответствующее сообщение
        if (choice >= 1 && choice <= options.length) {
            System.out.println("Вы выбрали: " + options[choice - 1]);
            switch (choice) {
                case 1:
                    useStack();
                    break;
                case 2:
                    useQueue();
                    break;
                case 3:
                    useTree();
                    break;
                case 4:
                    useAnyCountChildrenTree();
                    break;
                case 5:
                    useLinkedList();
                    break;
                case 6:
                    useSet();
                    break;
                case 7:
                    useBogoSort();
                    break;
            }
        } else {
            System.out.println("Неверный ввод. Пожалуйста, выберите номер из списка.");
        }

        // Закрываем scanner
        scanner.close();
    }

    public static void useStack() {
        Stack stack = new Stack(5); // Создаем стек размером 5

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Элемент на верхушке стэка: " + stack.peek());

        stack.pop();
        stack.pop();

        System.out.println("Размер стэка: " + stack.size());
    }
    public static void useQueue() {
        Queue queue = new Queue(5); // Создаем очередь размером 5

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Элемент на верхушке очереди: " + queue.peek());

        queue.dequeue();
        queue.dequeue();

        System.out.println("Размер очереди: " + queue.size());
    }
    public static void useTree() {
        BinaryTree tree = new BinaryTree();

        // Вставляем элементы в бинарное дерево
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Симметрич. обход:");
        tree.inorder();  // Ожидаемый вывод: 20 30 40 50 60 70 80

        System.out.println("\nПрямой обход дерева:");
        tree.preorder();  // Ожидаемый вывод: 50 30 20 40 70 60 80

        System.out.println("\nПостфиксный обход дерева:");
        tree.postorder();  // Ожидаемый вывод: 20 40 30 60 80 70 50

        System.out.println("\nПоиск элемента 40 в дереве:");
        System.out.println(tree.search(40));  // Ожидаемый вывод: true

        System.out.println("\nПоиск элемента 100 в дереве:");
        System.out.println(tree.search(100));  // Ожидаемый вывод: false
    }
    public static void useAnyCountChildrenTree() {
        AnyCountChildrenTree tree = new AnyCountChildrenTree(1);  // Корень дерева со значением 1

        // Создание узлов
        NodeWithChildren node2 = new NodeWithChildren(2);
        NodeWithChildren node3 = new NodeWithChildren(3);
        NodeWithChildren node4 = new NodeWithChildren(4);
        NodeWithChildren node5 = new NodeWithChildren(5);
        NodeWithChildren node6 = new NodeWithChildren(6);
        NodeWithChildren node7 = new NodeWithChildren(7);
        NodeWithChildren node8 = new NodeWithChildren(8);

        // Добавляем потомков
        tree.addChildToNode(tree.root, node2);
        tree.addChildToNode(tree.root, node3);
        tree.addChildToNode(tree.root, node4);

        tree.addChildToNode(node2, node5);
        tree.addChildToNode(node2, node6);

        tree.addChildToNode(node4, node7);
        tree.addChildToNode(node4, node8);

        // Обход дерева в глубину
        System.out.println("Поиск в глубину:");
        tree.depthFirstSearch();  // Ожидаемый вывод: 1 2 5 6 3 4 7 8

        System.out.println("\n\nПоиск в ширину:");
        tree.breadthFirstSearch();  // Ожидаемый вывод: 1 2 3 4 5 6 7 8

        // Поиск узла
        System.out.println("\n\nПоиск ноды со знач. 5:");
        NodeWithChildren foundNode = tree.findNode(5);
        if (foundNode != null) {
            System.out.println("Найдена: " + foundNode.data);
        } else {
            System.out.println("Лист не найден");
        }
    }
    public static void useLinkedList() {
        LinkedList list = new LinkedList();

        // Добавляем элементы в конец списка
        list.append(10);
        list.append(20);
        list.append(30);
        list.append(40);

        // Выводим список
        System.out.println("Список после добавления элементов:");
        list.printList();  // Ожидаемый вывод: 10 20 30 40

        // Добавляем элемент в начало списка
        list.prepend(5);
        System.out.println("Список после добавления знач. 5:");
        list.printList();  // Ожидаемый вывод: 5 10 20 30 40

        // Удаляем элемент
        list.delete(20);
        System.out.println("Список после удаления элемента 20:");
        list.printList();  // Ожидаемый вывод: 5 10 30 40

        // Поиск элемента
        System.out.println("Есть ли 30 в списке? " + list.search(30));  // Ожидаемый вывод: true
        System.out.println("Есть ли 25 в списке? " + list.search(25));  // Ожидаемый вывод: false

        // Получение размера списка
        System.out.println("Длина списка: " + list.size());  // Ожидаемый вывод: 4
    }
    public static  void useSet() {
        Set set = new Set();

        // Добавление элементов
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(10); // Повторяющийся элемент, не будет добавлен
        set.add(40);

        // Вывод множества
        System.out.println("Множество после добавления элементов:");
        set.printSet();  // Ожидаемый вывод: { 10 20 30 40 }

        // Удаление элемента
        set.remove(20);
        System.out.println("Множество после удаления элемента 20:");
        set.printSet();  // Ожидаемый вывод: { 10 30 40 }

        // Проверка на наличие элемента
        System.out.println("Содержится ли 30 в множестве? " + set.contains(30));  // Ожидаемый вывод: true
        System.out.println("Содержится ли 20 в множестве? " + set.contains(20));  // Ожидаемый вывод: false

        // Проверка размера множества
        System.out.println("Размер множества: " + set.size());  // Ожидаемый вывод: 3
    }

    public static void useBogoSort() {
        int[] array = {3, 1, 4, 1, 5, 9};

        System.out.println("Исходный массив: " + Arrays.toString(array));

        bogosort(array);

        System.out.println("Отсортированный массив: " + Arrays.toString(array));
    }
}