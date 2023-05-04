import java.util.Random;
public class Main {
    public static void main(String[] args) {
        long t= 0;

        int n = 6400;
        /*Random rnd = new Random();
            int[] arr = new int[n];
            for (int p = 0; p < arr.length; p++) {
                arr[p] = rnd.nextInt() ;
            }*/
                for (int i = 0; i <= 120; i++) {
                    int[] arrS = sorted(n);
                    int[] arrS2 = sorted(n);
                    long s = System.nanoTime();
                    System.out.println(binary_search(arrS, 100) /*+ " duplicates"*/);
                    long e = System.nanoTime();
                    System.out.println((e-s)/1000);
                    if(i > 19){
                        t += e-s;
                    }
                }
                System.out.println((t/100)/1000 + " Avg us");
            }

        public static boolean search_unsorted ( int[] array, int key){
            for (int index = 0; index < array.length; index++) {
                if (array[index] == key) {
                    return true;
                }
            }
            return false;
    }
    private static int[] sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;
        for (int i = 0; i < n ; i++) {
            nxt += rnd.nextInt(100000) + 1;
            array[i] = nxt;
        }
        return array;
    }
    public static boolean sortedSearch(int[] a, int key) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] > key) {
                return false;
            }else if(a[i] == key){
            break;
            }
        }return true;
    }
    public static boolean binary_search(int[] array, int key) {
        int first = 0;
        int last = array.length-1;
        while (true) {
// jump to the middle
        int index = first+(last-first)/2;
            if (array[index] == key) {
// hmm what now?
            return true;
            }
            if (array[index] < key && index < last) {
// The index position holds something that is less than
// what we're looking for, what is the first possible page?
                first = index + 1 ;
                continue;
            }
            if (array[index] > key && index > first) {
// The index position holds something that is larger than
// what we're looking for, what is the last possible page?
                last = index - 1;
                continue;
            }
// Why do we land here? What shoudl we do?
    if(first == last){
        break;
    } else break;
        }
        return false;
    }
    public static int dupSort(int[] array1, int[] array2){
            int nofDuplicates = 0;
            for(int i = 0; i < array1.length; i++){
                int key = array1[i];
                if(sortedSearch(array2, key)){
                    nofDuplicates++;
                }
            } return nofDuplicates;
    }

    public static int effDubSort(int[] array1, int[] array2){
        int i = 0;
        int j = 0;
        int nofDuplicates = 0;

        while(i < array1.length-1 && j < array2.length-1) {
            if (array1[i] == array2[j]) {
                nofDuplicates++;
                i++;
                j++;
            } else if (array1[i] < array2[j] && i < array1.length - 1) {
                i++;
            } else if (array1[i] > array2[j] && j < array2.length - 1) {
                j++;
            }
        } return nofDuplicates;
            }
        }
