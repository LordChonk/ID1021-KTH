public class TNode {
    int index;
    int value;

    TNode leftPointer;
    TNode rightPointer;

    public TNode(int index, int value){
        this.index = index;
        this.value = value;

        leftPointer = null;
        rightPointer = null;
    }
}
