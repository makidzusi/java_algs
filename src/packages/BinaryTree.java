package packages;

// Класс для представления узла дерева
class Node {
    int data;  // Значение узла
    Node left, right;  // Ссылки на левого и правого потомков

    // Конструктор для создания узла
    public Node(int item) {
        data = item;
        left = right = null;
    }
}

// Класс для представления бинарного дерева
public class BinaryTree {
    Node root;  // Корень дерева

    // Конструктор для создания дерева
    public BinaryTree() {
        root = null;
    }

    // Метод для вставки элемента в дерево
    public void insert(int data) {
        root = insertRec(root, data);
    }

    // Рекурсивный метод для вставки элемента в дерево
    private Node insertRec(Node root, int data) {
        // Если дерево пустое, возвращаем новый узел
        if (root == null) {
            root = new Node(data);
            return root;
        }

        // Иначе, рекурсивно спускаемся влево или вправо
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        // Возвращаем (неизмененный) указатель на узел
        return root;
    }

    // Метод для поиска элемента в дереве
    public boolean search(int key) {
        return searchRec(root, key);
    }

    // Рекурсивный метод для поиска элемента в дереве
    private boolean searchRec(Node root, int key) {
        // Если корень пустой или ключ найден
        if (root == null || root.data == key) {
            return root != null;
        }

        // Ищем в левом или правом поддереве
        if (key < root.data) {
            return searchRec(root.left, key);
        }

        return searchRec(root.right, key);
    }

    // Метод для обхода дерева в порядке "сначала левый, потом корень, потом правый" (in-order)
    public void inorder() {
        inorderRec(root);
    }

    // Рекурсивный метод для обхода дерева in-order
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);  // Сначала обрабатываем левое поддерево
            System.out.print(root.data + " ");  // Обрабатываем корень
            inorderRec(root.right);  // Обрабатываем правое поддерево
        }
    }

    // Метод для обхода дерева в порядке "сначала корень, потом левый, потом правый" (pre-order)
    public void preorder() {
        preorderRec(root);
    }

    // Рекурсивный метод для обхода дерева pre-order
    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");  // Обрабатываем корень
            preorderRec(root.left);  // Сначала обрабатываем левое поддерево
            preorderRec(root.right);  // Обрабатываем правое поддерево
        }
    }

    // Метод для обхода дерева в порядке "сначала левый, потом правый, потом корень" (post-order)
    public void postorder() {
        postorderRec(root);
    }

    // Рекурсивный метод для обхода дерева post-order
    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);  // Сначала обрабатываем левое поддерево
            postorderRec(root.right);  // Обрабатываем правое поддерево
            System.out.print(root.data + " ");  // Обрабатываем корень
        }
    }
}
