import java.util.Random;

public class BinaryHeap<P extends Comparable, T> {
    TNode root;

    private class TNode {
        private int prio;
        private T data;
        private int size;
        private TNode left;
        private TNode right;

        public TNode(int prio, T value, int size) {
            this.prio = prio;
            this.data = value;
            this.size = size;
            this.left = this.right = null;
        }

        // depth first traversal
        public void print() {
            if (left != null)
                left.print();
            System.out.println(" key: " + prio + "\tvalue: " + data);
            if (right != null)
                right.print();
        }

        private void add(int prio, T data) {
            // we want to move the data and prio of the current node down if the data we
            // want to add has lower priority than the node we're in
            if (prio < this.prio) {
                int tempPrio = this.prio;
                T tempData = this.data;
                this.prio = prio;
                this.data = data;
                prio = tempPrio;
                data = tempData;
            }
            this.size++;
            if (this.left == null) {
                this.left = new TNode(prio, data, 1);
            } else if (this.right == null) {
                this.right = new TNode(prio, data, 1);
            } else if (this.right.size < this.left.size) {
                this.right.add(prio, data);
            } else {
                this.left.add(prio, data);
            }

        }

        private TNode remove() {
            // if the left branch is empty we promote the right branch to root.
            if (this.left == null) {
                this.prio = this.right.prio;
                this.data = this.right.data;
                this.right = null;
                this.size--;
                return this;
            }
            // if the right branch is empty we promote the left branch to root
            if (this.right == null) {
                this.prio = this.left.prio;
                this.data = this.left.data;
                this.left = null;
                this.size--;
                return this;
            }
            if (this.left.prio < this.right.prio) {
                this.prio = this.left.prio;
                this.data = this.left.data;
                this.size--;
                if (this.left.size == 1) {
                    this.left = null;
                } else {
                    this.left = this.left.remove();
                }
                return this;
            } else {
                this.prio = this.right.prio;
                this.data = this.right.data;
                this.size--;
                if (this.right.size == 1) {
                    this.right = null;
                } else {
                    this.right = this.right.remove();
                }
            }
            return this;
        }
    }

    public BinaryHeap() {
        root = null;
    }

    public void BFSPrint() {
        Queue<TNode> queue = new Queue<TNode>();
        TNode current = root;
        if (current == null) {
            System.out.println("Heap is empty");
            return;
        }
        System.out.println(" key: " + current.prio + "\tvalue: " + current.data);
        if (current.left != null)
            System.out.println("\t left: " + current.left.prio);
        if (current.right != null)
            System.out.println("\t right: " + current.right.prio);
        while (current != null) {
            if (current.left != null) {
                queue.enqueue(current.left);
            }
            if (current.right != null) {
                queue.enqueue(current.right);
            }
            current = queue.dequeue();
            if (current == null)
                return;
            System.out.println(" key: " + current.prio + "\tvalue: " + current.data);
            if (current.left != null)
                System.out.println("\t left: " + current.left.prio);
            if (current.right != null)
                System.out.println("\t right: " + current.right.prio);
        }
    }


    public void add(int prio, T item) {
        if (root == null) {
            root = new TNode(prio, item, 1);
        } else {
            root.add(prio, item);
        }
    }

    public int remove() {
        if (root == null) {
            System.out.println("Heap is empty");
            return -1;
        } else if (root.left == null && root.right == null) {
            int oldRoot = (int) this.root.prio;  //oldRoot will be returned
            root = null;
            return oldRoot;
        } else {
            int oldRoot = (int) this.root.prio;
            root.remove();
            return oldRoot;
        }
    }

    public void swapMinUp(TNode swapDown, TNode swapUp) {

        int tempPrio = swapDown.prio;
        T tempData = swapDown.data;
        swapDown.prio = swapUp.prio;
        swapDown.data = swapUp.data;
        swapUp.prio = tempPrio;
        swapUp.data = tempData;
    }

    public int push(int incr) {
        this.root.prio += incr;
        TNode focusNode = this.root;
        return push(this.root.prio, focusNode, 0);

    }

    private int push(int newRoot, TNode focusNode, int depth) {
        if (focusNode.left == null) {
            if (newRoot < focusNode.right.prio) {
                return depth;
            } else if (focusNode.left.prio < newRoot) {
                depth++;
                swapMinUp(focusNode, focusNode.right);

            }
            if (focusNode.right.size != 1) {
                depth = push(newRoot, focusNode.right, depth);
            }
        }
        if (focusNode.right == null) {
            if (focusNode.left.prio > newRoot) {
                return depth;
            } else if (focusNode.left.prio < newRoot) {
                depth++;
                swapMinUp(focusNode, focusNode.left);
            }
            if (focusNode.left.prio != 1) {
                depth = push(newRoot, focusNode.left, depth);
            }
        }
        if (focusNode.left.prio > focusNode.right.prio) {
            if (focusNode.right.prio > newRoot) {
                return depth;
            } else if (focusNode.right.prio < newRoot) {
                depth++;
                swapMinUp(focusNode, focusNode.right);
            }
            if (focusNode.right.size != 1) {
                depth = push(newRoot, focusNode.right, depth);
            }
        } else {
            if (focusNode.left.prio > newRoot) {
                return depth;
            } else if (focusNode.left.prio < newRoot) {
                depth++;
                swapMinUp(focusNode, focusNode.left);
            }
            if (focusNode.left.size != 1) {
                depth = push(newRoot, focusNode.left, depth);
            }
        }
        return depth;
    }

    public void print() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        root.print();
    }

    public static void main(String[] args) {
        Random rnd = new Random();
        BinaryHeap tree = new BinaryHeap();
        /*tree.add(20, 20);
        tree.add(8, 8);
        tree.add(22, 22);
        tree.add(4, 4);
        tree.add(12, 12);
        tree.add(10, 10);
        tree.add(14, 14);*/
        for(int i = 0; i < 8000; i++){
            int prioData = rnd.nextInt(2500);
            tree.add(prioData, prioData);
        }

        tree.BFSPrint();
        System.out.println("--------------------------------------");

        long t = 0;
        for(int bCT = 0; bCT < 1000; bCT++){
            long s = System.nanoTime();
            System.out.println(tree.push(rnd.nextInt( 2400)));
            long e = System.nanoTime();
            t += (e-s);
        }

        //System.out.println(tree.push(100));
        System.out.println("Average time = " + t/100 + " ns");

        /*System.out.println("remove " + tree.remove());
        tree.BFSPrint();
        System.out.println("--------------------------------------");

        System.out.println("remove " + tree.remove());
        tree.BFSPrint();
        System.out.println("--------------------------------------");

        System.out.println("remove " + tree.remove());
        tree.BFSPrint();
        System.out.println("--------------------------------------");

        System.out.println("remove " + tree.remove());
        tree.BFSPrint();
        System.out.println("--------------------------------------");

        System.out.println("remove " + tree.remove());
        tree.BFSPrint();
        System.out.println("--------------------------------------");

        System.out.println("remove " + tree.remove());
        tree.BFSPrint();
        System.out.println("--------------------------------------");

        System.out.println("last remove " + tree.remove());
        tree.BFSPrint();
        System.out.println("--------------------------------------");
*/
       /* tree.push(9);
        tree.BFSPrint();
        System.out.println((tree.push(7)));*/
    }

}