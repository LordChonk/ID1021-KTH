public class ArrayQueue<Item> {

    Item[] queue;
    private int queuepointer;
    private int headpointer;

    int n = 2;
    int counter = 0;
    public ArrayQueue() {
        this.queue = (Item[]) new Object[n];
        queuepointer = 0;
        headpointer = 0;
    }

    public void loopCheck(){
        if (queuepointer == this.queue.length){
            queuepointer = 0;
        }
        if (headpointer == this.queue.length){
            headpointer = 0;
        }
    }

    public void sizeCheck(){
        if (isFull()){
            n = n*2;
            Item[] queueCopy = (Item[]) new Object[n];
            int localI = 0;
            if (headpointer < queuepointer) {
                for (int i = headpointer; i < queuepointer+1; i++) {
                    if (queue[i] != null){
                        queueCopy[localI++] = queue[i];
                    }
                }
            }
            else {
                for (int i = headpointer; i < queue.length; i++) {
                    if (queue[i] != null){
                        queueCopy[localI++] = queue[i];
                    }
                }
                for (int i = 0; i < queuepointer; i++) {
                    if (queue[i] != null){
                        queueCopy[localI++] = queue[i];
                    }
                }
            }
            this.queue = queueCopy;
            headpointer = 0;
            queuepointer = counter;
        }
    }

    public void shrinkCheck(){
        if (counter < n/4) {
            n = n/2;
            Item[] queueCopy = (Item[]) new Object[n];
            if (headpointer < queuepointer) {
                int localI = 0;
                for (int i = headpointer; i <queuepointer+1; i++) {
                    queueCopy[localI++] = queue[i];
                }
            }
            if (headpointer > queuepointer){
                int localI = 0;
                for (int i = headpointer; i < queue.length; i++) {
                    if (queue[i] != null){
                        queueCopy[localI++] = queue[i];
                    }
                }
                for (int i = 0; i < queuepointer; i++) {
                    if (queue[i] != null){
                        queueCopy[localI++] = queue[i];
                    }
                }

            }
            this.queue = queueCopy;
            headpointer = 0;
            queuepointer = counter;
        }
    }
    public boolean isFull(){
        loopCheck();
        return (queuepointer == headpointer && queue[headpointer] != null);
    }

    public boolean isEmpty(){
        loopCheck();
        return (queuepointer == headpointer && queue[headpointer] == null);
    }

    public void add(Item item) {
        sizeCheck();
        if (!isFull()){
            queue[queuepointer++] = item;
            loopCheck();
            counter++;
        }
    }
    public Item poll() {
        if (isEmpty()){
            return null;
        }
        Item removedItem = this.queue[this.headpointer];
        this.queue[this.headpointer++] = null;
        counter--;
        shrinkCheck();
        return removedItem;
    }

}

