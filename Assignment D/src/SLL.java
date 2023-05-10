public class SLL {
        Node head;
        Node next;
        class Node {
            public int data;
            public Node next;

            public void setNext(Node next) {
                this.next = next;
            }

        }

        public void insert(int data) {
            Node node = new Node();
            node.data = data;
            node.next = null;

            if (head == null) {
                head = node;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = node;
            }
            next = node;
        }

        public void show() {
            Node node = head;
            while (node.next != null) {
                System.out.println(node.data);
                node = node.next;
            }
            System.out.println(node.data);
        }
        public int valueAt(int index){
        Node temp = get(index);
        return temp.data;
        }

        public void inStart(int data) {
            Node node = new Node();
            node.data = data;
            node.next = null;
            node.next = head;
            head = node;

        }

        public void insAt(int index, int data) {
            Node node = new Node();
            node.data = data;
            node.next = null;

            if (index == 0) {
                inStart(data);
            } else {
                Node temp = head;
                for (int i = 0; i < index - 1; i++) {
                    temp = temp.next;
                }
                node.next = temp.next;
                temp.next = node;
            }
        }
        public void delAt(int index){
            if(index==0){
                head = head.next;
            }else{
                Node temp = head;
                Node temp1 = null;
                for (int i = 0; i < index - 1; i++) {
                    temp = temp.next;
                }
                temp1 = temp.next;
                temp.next = temp1.next;
            }
        }



        public void append(SLL a, SLL b){
            Node temp = null;

            Node appended = null;
            temp = a.getNext();
            appended = b.getHead();

            temp.next = appended;
            while(appended.next != null){
                appended = appended.next;
            }
        }

        private Node getNext() {
            return next;
        }
        public Node getHead() {
            return head;
        }
        public Node get(int pos) {
            Node temp = null;
            for (int i = 0; i < pos; i++) {
                temp = head;
                temp = temp.next;
            }
            return temp.next;
        }

    }


