import java.util.Random;
public class srch3 {
    public static void main(String[] args) {
        int n=13000;
        for (int i = 1000; i <= n; i+=1000) {
        System.out.println(time(100, /*10,*/ i) + " nanoseconds");
        }
    }

    private static double time(/*int m, */int k, int n) {
        long t_total = 0;
        int sum = 0;
        Random rnd = new Random();
        int[] keys = new int[n];
        int[] array = new int[n];
        for (int j = 0; j < k; j++) {
            keys[j] = rnd.nextInt(10*n);
            array[j] = rnd.nextInt(10*n);
            long t0 = System.nanoTime();
            for (int ki = 0; ki < n; ki++) {
                int key = keys[ki];
                for (int i = 0; i < n; i++) {
                    if (array[i] == key) {
                        sum++;
                        break;
                    }
                }
            }
            t_total += (System.nanoTime() - t0);
        }return t_total/k;
    }
}
