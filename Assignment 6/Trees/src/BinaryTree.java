import javax.naming.InsufficientResourcesException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.*;

public class BinaryTree implements Iterable<Integer> {
    public Node root;

    
    public BinaryTree() {
        root = null;
    }

    public void add(int key, int value) {
        Node leaf = new Node(key, value);
        if (root == null) {
            root = leaf;
        } else {
            Node focusNode = root;
            Node parent;
            while (true) {
                parent = focusNode;
                if (key < focusNode.key) {
                    focusNode = focusNode.left;
                    if (focusNode == null) {
                        parent.left = leaf;
                        return;
                    }
                } else {
                    focusNode = focusNode.right;
                    if (focusNode == null) {
                        parent.right = leaf;
                        return;
                    }
                }
            }
        }
    } //End of add

    public void inOrder(Node focusNode) {
        if (focusNode != null) {
            inOrder(focusNode.left);
            System.out.println(focusNode);
            inOrder(focusNode.right);
        }
    }



   /*@Override
    public Iterator<Integer> iterator() {
        return new TreeIterator();
    }

    public class TreeIterator implements Iterator<Integer> {
        private Node next;
        private Stack<Node> stack;

        public TreeIterator() {
            this.stack = new Stack<Node>();
            this.stack.push(root);
            this.next = root.left;
        }


        @Override
        public boolean hasNext() {
            return this.next != null;
        }

        @Override
        public Integer next() {
            if(hasNext()){
                this.stack.push(next);
                this.next = next.left;

            }
            if(right != null) right.DFSprint();
        }
    }*/



        public Integer lookup(Integer key) {
            Node focusNode = root;
            while (key != focusNode.key) {
                if (key > focusNode.key) {
                    focusNode = focusNode.right;
                } else if (key < focusNode.key) {
                    focusNode = focusNode.left;
                } else {
                    return null;
                }
            }
            return focusNode.value;
        }
    public Iterator<Integer> iterator() {
        return new TreeIterator(root);
    }

    public class TreeIterator implements Iterator<Integer> {
        private Node next;
        private Stack<Node> stack;

        public TreeIterator(Node current) {
            stack = new Stack<Node>();
            moveLeft(current);
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();

        }

        // we start all the way at the bottom left with the pointer pointing at null.
        // We then pop the stack and set that node to curr, and check if curr has
        // branches down to the right.
        // If it does we push that to the stack and all the branches down left from it.
        // we then return the value of curr. This way next time we call this method the
        // top node on the stack will be the node furthest down on the left of the node
        // on the right of curr and should thus be the next smallest key in the tree
        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Node focusNode = stack.pop();
            if (focusNode.right != null) {
                moveLeft(focusNode.right);
            }
            next = focusNode;
            return focusNode.value;
        }

        // we want to move all the way down left first so as long as current
        // isn't null we push the current node to the stack and then move
        // down left till we reach the null pointer
        private void moveLeft(Node focusNode) {
            while (focusNode != null) {
                stack.push(focusNode);
                focusNode = focusNode.left;
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    }









