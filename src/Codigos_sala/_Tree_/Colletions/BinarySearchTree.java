package Codigos_sala._Tree_.Colletions;

import Codigos_sala._Queue_.Collections._Queues_.DynamicQueue;

public class BinarySearchTree<E> extends BinaryTree<E> {



    @Override
    public void insert(E value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            root = newNode;
        } else {
            Node auxNode = root;
            while (auxNode != null) {
                if (compare(newNode, auxNode) == 0) {
                    return;
                } else if (compare(newNode, auxNode) < 0) {
                    if (auxNode.left == null) {
                        auxNode.left = newNode;
                        break;
                    }
                    auxNode = auxNode.left;
                } else {
                    if (auxNode.right == null) {
                        auxNode.right = newNode;
                        break;
                    }
                    auxNode = auxNode.right;
                }
            }
        }
        size++;
    }

    private String breadthFirstSearch() {
        DynamicQueue<Node> queue = new DynamicQueue<>();
        if (!isEmpty()) {
            queue.enqueue(root);
        }
        String treeData = "";
        while (!queue.isEmpty()) {
            Node auxNode = queue.dequeue();
            treeData += auxNode.value;

            if (auxNode.left != null) queue.enqueue(auxNode.left);

            if (auxNode.right != null) queue.enqueue(auxNode.right);

            if (!queue.isEmpty()) treeData += ", ";
        }
        return treeData;
    }

    @Override
    public E delete(E value) {
        return null;
    }

    @Override
    public E get(E value) {
        return null;
    }

    public String treeTraversal() {
        return breadthFirstSearch();
    }
    public String treeTraversal(String type) {
        if (type.equals("bfs")) {
            return breadthFirstSearch();
        } else {
            if (type.equals("inOrder")) {
                return "";
            } else if (type.equals("preOrder")) {
                return "";
            } else {
                return "";
            }
        }
    }
}
