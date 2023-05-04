package se.kth.abahjert;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Item[] items = { new Item(ItemType.VALUE,10),new Item(ItemType.VALUE, 0)
                ,new Item(ItemType.VALUE, 2),new Item(ItemType.SMUL, 0)
                ,new Item(ItemType.VALUE, 1),new Item(ItemType.ADD, 0)
                ,new Item(ItemType.VALUE, 1),new Item(ItemType.VALUE, 2)
                ,new Item(ItemType.SMUL, 0),new Item(ItemType.ADD, 0)
                ,new Item(ItemType.VALUE, 0),new Item(ItemType.ADD,0)
                ,new Item(ItemType.VALUE, 0),new Item(ItemType.VALUE, 2)
                ,new Item(ItemType.SMUL,0),new Item(ItemType.ADD, 0)
                ,new Item(ItemType.VALUE, 2),new Item(ItemType.ADD, 0)
                ,new Item(ItemType.VALUE, 0),new Item(ItemType.VALUE, 2)
                ,new Item(ItemType.SMUL, 0),new Item(ItemType.ADD, 0)
                ,new Item(ItemType.VALUE, 0),new Item(ItemType.ADD, 0)
                ,new Item(ItemType.VALUE, 5),new Item(ItemType.VALUE, 2)
                ,new Item(ItemType.SMUL, 0),new Item(ItemType.ADD, 0)
                ,new Item(ItemType.MOD,0),new Item(ItemType.SUB, 0)};
        long s = System.nanoTime();
        Calculator HP35 = new Calculator(items);
        System.out.println(HP35.run());
    long e = System.nanoTime();
        //Stack s1 = new Stack();
        //s1.printStack();
    System.out.println((e-s)/1000 + " us");
    }
}
