public class SimpleRev {
    Node head;

    public void add(int data){
        Node added = new Node(data);
        //Case: List is empty
        if(head == null){
            added.data = data;
            head = added;
            //added.next = null;
        }else if(added.data < head.data){
            added.next = head;
            head = added;
        }
        else if(added.data > head.data){
            Node temp = head;
            while(temp.next != null && temp.data < added.data){
                temp = temp.next;
            }
            Node temp2 = temp.next;
            temp.next = added;
            added.next = temp2;
        }
    }
    public Node remove(){
        Node temp = head;
        head = head.next;
        return temp;
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
    /*public void add(int data){
        Node added = new Node(data);
        if(head == null){
            head = added;
            head.next = null;
        }else{
            Node temp = head;
            if(added.data < head.data){

            }
        }
    }*/
}
