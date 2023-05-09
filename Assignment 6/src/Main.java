import java.util.NoSuchElementException;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int n = 100;
        Random rnd = new Random();
        BinaryTree tree = new BinaryTree();
        tree.add(5,105);
        tree.add(2,102);
        tree.add(7,107);
        tree.add(1,101);
        tree.add(8,108);
        tree.add(6,106);
        tree.add(3,103);
        /*for(int i = 0; i < n; i++) {
            tree.add(rnd.nextInt(n), rnd.nextInt(10*n));
        }*/


      //tree.inOrder(tree.root);
        //tree.print();
       /* long t = 0;
            for (int i = 0; i < 100; i++) {
                long s = System.nanoTime();
                System.out.println(tree.lookup(3));
                long e = System.nanoTime();
                t += (e - s);
            }
            System.out.println("Avg time = " + (t / 100) + " ns");*/
        for(int i : tree) {
          System.out.println("Next value " + i) ;
        }

        /*try {
            System.out.print(itr.next().value + " ");
            System.out.print(itr.hasNext() + " ");
            System.out.print(itr.next().value + " ");
            System.out.print(itr.next().value + " ");
            System.out.print(itr.next().value + " ");
            System.out.print(itr.hasNext() + " ");
            System.out.print(itr.next().value + " ");
            System.out.print(itr.next().value + " ");
            System.out.print(itr.hasNext() + " ");
        }
        catch (NoSuchElementException r) {
            System.out.print("No such element exists");
        }*/
    }
}