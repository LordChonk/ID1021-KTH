import java.util.Arrays;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        int n = 1100;
        Random rnd = new Random();
        int[] selSortArr = new int[n];
        int[] insortArr = new int[n];//{2, 1, 9, 4, 3, 5};
        int[] mergSortArr = new int[n];
        for (int i = 0; i < n-1; i++) {
            selSortArr[i] = rnd.nextInt(10 * n);
            insortArr[i] = rnd.nextInt(10 * n);
            mergSortArr[i] = rnd.nextInt(10 * n);
        }
        long t1 = 0;
        long t2 = 0;
        long t3 = 0;
        for (int l = 0; l < 100; l++) {
            long s1 = System.nanoTime();
            selsort(selSortArr);
            long e1 = System.nanoTime();
            //System.out.println(e1-s1);
            t1 += (e1 - s1);
            long s2 = System.nanoTime();
            insort(insortArr);
            long e2 = System.nanoTime();
            //System.out.println(e2-s2);
            t2 += (e2 - s2);
            long s3 = System.nanoTime();
            mergeSort(mergSortArr);
            long e3 = System.nanoTime();
            t3 += (e3-s3);
        }

        System.out.println(t1 / 100 / 1000 + " avg time selsort us");
        System.out.println(t2 / 100 / 1000 + " avg time insort us");
        System.out.println(t3/100/1000 + " avg time mergeSort us");
        //System.out.println("Before:" + Arrays.toString(mergSortArr));
        //mergeSort(mergSortArr);
        //System.out.println(Arrays.toString(insort(insortArr)));
        //System.out.println("After: " + Arrays.toString(mergSortArr));
    }

    public static int[] selsort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
// let's set the first candidate to the index itself
            int cand = i;
            for (int j = i; j < array.length; j++) {
// If the element at position j is smaller than the value
// at the candidate position - then you have a new candidate
// posistion.
                if (array[j] < array[cand]) {
                    int swp = array[j];
                    array[j] = array[cand];
                    array[cand] = swp;
                }
            }
        }
        return array;
    }

    public static int[] insort(int[] array) {
        for (int i = 0; i < array.length; i++) {
// for each element from i towards 1, swap the item found with the
// item before it if it is smaller
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int swp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = swp;
                }
            }
        }
        return array;
    }

    public static void mergeSort(int[] array) {
        int inLen = array.length;
        if(inLen < 2){
            return;
        }
        int mid = inLen/2;
        int[] left = new int[mid];
        int[] right = new int[inLen-mid];
        for(int i = 0; i < mid; i++){
            left[i] = array[i];
        }
        for(int i = mid; i < inLen; i++){
           right[i-mid] = array[i];
        }

        mergeSort(left);
        mergeSort(right);

            merge(array, left, right);
    }
    private static void merge(int[] array, int[] left, int[]right){
        int lSize = left.length;
        int rSize = right.length;

        int i = 0, j = 0, k = 0;

        while(i < lSize && j < rSize){
            if(left[i] <= right[j]){
                array[k] = left[i];
                i++;
            }
            else{
                array[k] = right[j];
                j++;
            }
            k++;
        }
        while(i < lSize){
            array[k] = left[i];
                i++;
                k++;
        }
        while(j < rSize){
            array[k] = right[j];
                j++;
                k++;
        }
    }
}
