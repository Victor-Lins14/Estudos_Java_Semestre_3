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



    @Override
    public E get(E value) {
        return null;
    }

    public String treeTraversal() {
        return breadthFirstSearch();
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

    @Override
    public String toString() {
        return treeTraversal();
    }
}
