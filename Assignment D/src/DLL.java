import java.util.NoSuchElementException;

public class DLL {

    private Node head;
    private Node tail;
    private int length;

    private class Node{
        private int data;
        private Node next;
        private Node prev;

        public Node(int data){
            this.data = data;
        }
    }
    public DLL(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }
    public boolean isEmpty(){
        return length == 0;
    }
    public int length(){
        return length;
    }
    public int valueAt(int pos){
        Node temp = head;
        int i = 0;
        while(i < pos){
            temp = temp.next;
            i++;
        }
        return temp.data;
    }
    public void showFwd(){
        if(head == null){
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data + " Forward");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public void showBck(){
        if(tail == null){
            return;
        }
        Node temp = tail;
        while(temp != null){
            System.out.println(temp.data + " Back");
            temp = temp.prev;
        }System.out.println("null");
    }
    public void insFirst(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            tail = newNode;
        }else{
            head.prev = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }
    public void insLast(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            head = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        length++;
    }
    public Node delFirst(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Node temp = head;
        if(head == tail){
            tail = null;
        }else{
            head.next.prev = null;
        }
        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }
    public Node delLast(){
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        Node temp = tail;
        if(head == tail){
            head = null;
        }else{
            tail.prev.next = null;
        }
        tail = tail.prev;
        temp.prev = null;
        length--;
        return temp;
    }
    public void insAt(int data, int pos){
        Node newNode = new Node(data);
        int i = 0;
        Node temp = this.head;
        while(i < pos){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next.prev = newNode;
        temp.next = newNode;
        newNode.prev = temp;
        length++;
    }
    public void delAt(int pos){
        Node temp = this.head;
        int i = 1;
        while(i <= pos){
            temp = temp.next;
            i++;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.next = null;
        temp.prev = null;
        length--;
    }
}
