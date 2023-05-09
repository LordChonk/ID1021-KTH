import java.util.NoSuchElementException;

public class Simple {
    Node head;
    Node tail;
    Node next;


    public void add(int data){
            Node added = new Node(data);
            added.data = data;
            added.next = head;
            head = added;
        }

        public Node remove() {
            Node min = head;
            Node temp = head;
            Node prev = null;
            while(temp != null) {
                if(temp.next != null && temp.next.data < min.data){
                    min = temp.next;
                    prev = temp;
                }
                temp = temp.next;
            }

            if(min != head) { //First element is not min
                prev.next = min.next;
            } else {
                head = head.next; //If first element is smallest, update the head
            }

            return head;
        }

    public void show() {
       Node temp = head;
      // System.out.println(head.data);
       while(temp.next != null){
           System.out.println(temp.data);
           temp = temp.next;
       }
       System.out.println(temp.data);
        }






        /*public void add(int data) {
        Node added = new Node(data);
        if (head == null) {
            head = added;
            added.next = null;
        } else if (added.data < head.data) {
            Node temp = head;
            head = added;
            head.next = temp;
        } else if (added.data > head.data) {
            Node temp = head;
            while (temp.next != null && added.data > temp.data) {
                temp = temp.next;
            }
                temp.next = added;
                added.next = null;
            }
        }*/
    }

