import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int n = 1000;
        int c = 1000;
        Random rnd = new Random();
        int[] array = new int[n];
        int[] array2 = new int[c];

        for (int i = 0; i < n; i++) {
            array[i] = rnd.nextInt(9);
        }
        for (int j = 0; j < c; j++) {
            array2[j] = rnd.nextInt(9);
        }

        LinkedList list2 = new LinkedList();
        for (int j = 0; j < c; j++) {
            list2.insert(rnd.nextInt(9));
        }
        LinkedList list = new LinkedList();
        for (int i = 0; i < n; i++) {
            list.insert(rnd.nextInt(9));
        }
        LinkedList built = new LinkedList();
        //list.show();
        //System.out.println("Break");
        //list2.show();
        //System.out.println("Break");
        //list.inStart(3);
        //list.append(list, list2);
        //list.show();
        long t = 0;
        long ta = 0;
        long tBL = 0;
        long tBA = 0;
        long tFA = 0;
        for (int ct = 0; ct < 100; ct++) {

            long s = System.nanoTime();
            list2.append(list2, list);
            long e = System.nanoTime();
            //list2.show();
            t += (e - s);
            long sa = System.nanoTime();
            //System.out.println(Arrays.toString(appendArray(array, array2)));
            appendArray(array, array2);
            long ea = System.nanoTime();
            ta += (ea - sa);

           /* long sBL = System.nanoTime();
            for(int b = 0; b < n; b++){
                built.insert(rnd.nextInt(9));
            }
            long eBL = System.nanoTime();
            tBL += (eBL - sBL);
            */
            long sBA = System.nanoTime();
            int[] builtArr = new int[n];
            long eBA = System.nanoTime();
            tBA += (eBA - sBA);

           /* long sFA = System.nanoTime();
            for(int i = 0; i < n; i++ ){
                builtArr[i] = rnd.nextInt(9);
            }
            long eFA = System.nanoTime();
            tFA += (eFA - sFA);
        */}
        //System.out.println(Arrays.toString(array));
        //System.out.println(Arrays.toString(array2));
       // System.out.println(Arrays.toString(appendArray(array, array2)));
        //System.out.println(ta / 100 +  " ns");
        //System.out.println(t / 100 + " ns");
        System.out.println("AvgT to build list of " + n + " elements = " + tBL/100/1000 + " us");
        System.out.println("AvgT to build array of " + n + " elements = " + tBA/100 + " ns");
        System.out.println("AvgT to fill array of " + n + " elements = " + tFA/100 + " ns");
    }

    public static int[] appendArray(int[] a, int[] b) {
        int[] appended = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            appended[i] = a[i];
        }
        for (int j = 0; j < b.length; j++) {
                appended[j+a.length] = b[j];
            }return appended;
        }
    }


