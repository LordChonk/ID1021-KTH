import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree implements Iterable<Integer> {
    TNode root;
    public Queue<TNode> q = new LinkedList<>();
    public ArrayQueue<TNode> arrayQ = new ArrayQueue<>();
    public void addLeaf(int index, int value) {
        TNode leaf = new TNode(index, value);

        if (root == null) {
            root = leaf;
        } else {
            TNode TNode = root;
            while (TNode.rightPointer != null || TNode.leftPointer != null) {
                if (index < TNode.index && TNode.leftPointer != null) {
                    TNode = TNode.leftPointer;
                }
                if (index == TNode.index) {
                    TNode.value += leaf.value;
                    break;
                }
                if (index > TNode.index && TNode.rightPointer != null) {
                    TNode = TNode.rightPointer;
                } else {
                    break;
                }
            }
            if (index < TNode.index) {
                TNode.leftPointer = leaf;
            }
            if (index == TNode.index) {
            }
            if (index > TNode.index) {
                TNode.rightPointer = leaf;
            }
        }
    }

    public Iterator<Integer> iterator() {
        return new TreeIterator(root);
    }
    public class TreeIterator implements Iterator<Integer> {
        public TreeIterator(TNode root) {
            arrayQ.add(root);
        }

        @Override
        public boolean hasNext() {
            return !(arrayQ.isEmpty());
        }

        @Override
        public Integer next() {
            if (hasNext()){
                TNode node = arrayQ.poll();
                if (node.leftPointer != null){
                    arrayQ.add(node.leftPointer);
                }
                if (node.rightPointer != null){
                    arrayQ.add(node.rightPointer);
                }
                return node.index;
            }
            else {
                return null;
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public void BFSPRint(){
        q.add(root);
        while (!q.isEmpty()){
            TNode node = q.poll();
            System.out.println(node.index);
            if (node.leftPointer != null){
                q.add(node.leftPointer);
            }
            if (node.rightPointer != null){
                q.add(node.rightPointer);
            }
        }
    }

    public void BFSPRintArray(){
        arrayQ.add(root);
        while (!arrayQ.isEmpty()){
            TNode node = arrayQ.poll();
            System.out.println(node.index);
            if (node.leftPointer != null){
                arrayQ.add(node.leftPointer);
            }
            if (node.rightPointer != null){
                arrayQ.add(node.rightPointer);
            }
        }
    }

}
