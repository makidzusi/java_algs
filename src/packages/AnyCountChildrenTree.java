package packages;

import java.util.ArrayList;
import java.util.List;

// Класс для представления дерева с произвольным числом детей
public class AnyCountChildrenTree {
    public NodeWithChildren root;  // Корень дерева

    // Конструктор для создания дерева с корнем
    public AnyCountChildrenTree(int rootData) {
        root = new NodeWithChildren(rootData);
    }

    // Метод для обхода дерева в глубину (DFS)
    public void depthFirstSearch() {
        dfs(root);
    }

    // Рекурсивный метод для обхода дерева в глубину
    private void dfs(NodeWithChildren node) {
        if (node == null) {
            return;
        }

        // Обрабатываем текущий узел
        System.out.print(node.data + " ");

        // Рекурсивно обрабатываем всех потомков
        for (NodeWithChildren child : node.children) {
            dfs(child);
        }
    }

    // Метод для обхода дерева в ширину (BFS)
    public void breadthFirstSearch() {
        bfs(root);
    }

    // Метод для обхода дерева в ширину
    private void bfs(NodeWithChildren node) {
        if (node == null) {
            return;
        }

        List<NodeWithChildren> queue = new ArrayList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            NodeWithChildren current = queue.removeFirst();
            System.out.print(current.data + " ");

            // Добавляем всех детей в очередь
            queue.addAll(current.children);
        }
    }

    // Метод для добавления потомка к узлу
    public void addChildToNode(NodeWithChildren parent, NodeWithChildren child) {
        parent.addChild(child);
    }

    // Метод для поиска узла по значению
    public NodeWithChildren findNode(int value) {
        return findNodeRec(root, value);
    }

    // Рекурсивный метод для поиска узла
    private NodeWithChildren findNodeRec(NodeWithChildren node, int value) {
        if (node == null) {
            return null;
        }

        if (node.data == value) {
            return node;
        }

        // Рекурсивный поиск среди всех детей
        for (NodeWithChildren child : node.children) {
            NodeWithChildren result = findNodeRec(child, value);
            if (result != null) {
                return result;
            }
        }
        return null;
    }
}