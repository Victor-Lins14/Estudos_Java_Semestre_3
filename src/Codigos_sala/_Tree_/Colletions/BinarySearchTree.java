package Codigos_sala._Tree_.Colletions;

import Codigos_sala._Queue_.Collections._Queues_.DynamicQueue;
import Codigos_sala._Stacks_.Collections.DynamicStack;

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

    private E removeRightMinNode(Node parent) {
        Node minNode = parent.right;
        while (minNode.left != null) {
            parent = minNode;
            minNode = minNode.left;
        }

        if (parent.right == minNode) {
            parent.right = minNode.right;
        } else {
            parent.left = minNode.right;
        }
        return minNode.value;
    }

    @Override
    public E delete(E value) {
        Node target = root, parent = null;
        while(target != null && compare(value, target)!=0) {
            parent = target;
            if (compare(value, target) < 0) {
                target = target.left;
            } else {
                target = target.right;
            }
        }

        if (target == null) return null;

        E removed = target.value;
        if (target.left != null && target.right != null) {
            target.value = removeRightMinNode(target);
        } else {
            Node child = target.left != null ? target.left : target.right;
            if (target == root) {
                root = child;
            } else {
                if (parent.left == target) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
            }
        }

//        if (target.left == null && target.right == null) {
//            if (parent == null || target == root) {
//                root = null;
//            } else {
//                if (parent.left == target) {
//                    parent.left = null;
//                } else {
//                    parent.right = null;
//                }
//            }
//        } else if (target.left != null && target.right != null) {
//            if (compare(target.left, target.right) < 0) {
//
//            }
//        } else {
//            Node child = target.left != null ? target.left : target.right;
//            if (target == root) {
//                root = child;
//            } else {
//                if (parent.left == target) {
//                    parent.left = child;
//                } else {
//                    parent.right = child;
//                }
//            }
//        }
        size--;

        return removed;
    }

    public int depth(E value) {
        if (isEmpty()) {
            return -1; // Valor não encontrado
        }

        DynamicQueue<Node> queue = new DynamicQueue<>();
        queue.enqueue(root);
        int currentDepth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // Processa todos os nós do nível atual
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.dequeue();

                // Se encontrou o valor, retorna a profundidade atual
                if (compare(value, current) == 0) {
                    return currentDepth;
                }

                if (current.left != null) {
                    queue.enqueue(current.left);
                }

                if (current.right != null) {
                    queue.enqueue(current.right);
                }
            }

            currentDepth++; // Avança para o próximo nível
        }

        return -1; // Valor não encontrado
    }

    public int height() {
        if (isEmpty()) {
            return -1; // Árvore vazia tem altura -1
        }

        DynamicQueue<Node> queue = new DynamicQueue<>();
        queue.enqueue(root);
        int height = -1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            height++;

            // Processa todos os nós do nível atual
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.dequeue();

                if (current.left != null) {
                    queue.enqueue(current.left);
                }

                if (current.right != null) {
                    queue.enqueue(current.right);
                }
            }
        }

        return height;
    }

    public boolean isComplete() {
        if (isEmpty()) {
            return false;
        }

        DynamicQueue<Node> queue = new DynamicQueue<>();
        queue.enqueue(root);
        boolean foundNull = false;

        while (!queue.isEmpty()) {
            Node current = queue.dequeue();

            // Se já encontramos um null e agora temos um nó não-null, não é completa
            if (current == null) {
                foundNull = true;
            } else {
                // Se já encontramos um null antes e agora temos um nó, não é completa
                if (foundNull) {
                    return false;
                }

                // Adiciona os filhos na fila (mesmo que sejam null)
                queue.enqueue(current.left);
                queue.enqueue(current.right);
            }
        }

        return true;
    }

    public boolean isFull() {
        if (isEmpty()) {
            return false;
        }

        DynamicStack<Node> stack = new DynamicStack<>();
        stack.push(root);
        int count = 0;

        while (!stack.isEmpty()) {
            Node current = stack.pop();

            // Se o nó não tem filhos, é uma folha
            if (current.left != null && current.right != null) count++;

            if (current.left == null && current.right == null) count++;

            // Adiciona os filhos na pilha para serem processados
            if (current.right != null) stack.push(current.right);

            if (current.left != null) stack.push(current.left);
        }

        return count == size;
    }

    public int leafCount() {
        if (isEmpty()) {
            return 0;
        }

        DynamicStack<Node> stack = new DynamicStack<>();
        stack.push(root);
        int count = 0;

        while (!stack.isEmpty()) {
            Node current = stack.pop();

            // Se o nó não tem filhos, é uma folha
            if (current.left == null && current.right == null) count++;

            // Adiciona os filhos na pilha para serem processados
            if (current.right != null) stack.push(current.right);

            if (current.left != null) stack.push(current.left);
        }

        return count;
    }

    public int internalNodeCount() {
        return size-leafCount();
    }

    @Override
    public E get(E value) {
        return null;
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

    private String preOrder() {
        DynamicStack<Node> stack = new DynamicStack<>();
        if (!isEmpty()) {
            stack.push(root);
        }
        String treeData = "";
        while (!stack.isEmpty()) {
            Node auxNode = stack.pop();
            treeData += auxNode.value;

            if (auxNode.right != null) stack.push(auxNode.right);


            if (auxNode.left != null) stack.push(auxNode.left);


            if (!stack.isEmpty()) treeData += ", ";
        }
        return treeData;
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
                return preOrder();
            } else {
                return "";
            }
        }
    }

    @Override
    public String toString() {
        return treeTraversal();
    }
}
