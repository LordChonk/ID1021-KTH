import java.util.Arrays;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        int k = 100;
        int n = 200000;
        Random fillSLL = new Random();
        Random fillDLL = new Random ();
        DLL list = new DLL();
        SLL list2 = new SLL();
        for(int c = 0; c < n; c++){
            list.insLast(fillDLL.nextInt(n));
            list2.insert(fillSLL.nextInt(n));
        }
        int[] sequence = new int[k];
        Random rnd = new Random();
        for (int i = 0; i < k; i++) {
            sequence[i] = rnd.nextInt(n-1);
        }
        System.out.println(Arrays.toString(sequence));
        long tdll = 0;
        long tsll = 0;
        for(int i = 0; i < 100; i++){
        for(int t = 0; t < k; t++){
            int data = list.valueAt(sequence[t]-1);
            int data2 = list2.valueAt(sequence[t]);
            //System.out.println("data2 = " + data2);
            long sdll = System.nanoTime();
            list.delAt(sequence[t]-1);
            list.insAt(data, sequence[t]-2);
            long edll = System.nanoTime();
            tdll += (edll - sdll);

            long ssll = System.nanoTime();
            list2.delAt(sequence[t]-1);
            list2.insAt(sequence[t]-1, data2);
            long esll = System.nanoTime();
            tsll += (esll - ssll);
        }
    }

        System.out.println("Doubly Linked List time = " + (tdll/100) + " ns");
        System.out.println("Singly Linked List time = " + (tsll/100) + " ns");
    }
}


