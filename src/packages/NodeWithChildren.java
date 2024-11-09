package packages;

import java.util.ArrayList;
import java.util.List;

public class NodeWithChildren {
    public int data;  // Значение узла
    List<NodeWithChildren> children;  // Список детей узла

    // Конструктор для создания узла с данным значением
    public NodeWithChildren(int data) {
        this.data = data;
        this.children = new ArrayList<>();  // Инициализация списка детей
    }

    // Метод для добавления потомка
    public void addChild(NodeWithChildren child) {
        children.add(child);
    }
}
