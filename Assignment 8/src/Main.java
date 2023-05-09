import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int n = 6400;
        Simple s = new Simple();
        Random rnd = new Random();
        long tadd = 0;
        for (int i = 0; i < n; i++) {
            s.add(rnd.nextInt(3 * n));
        }
            /*for(int ct = 0; ct < 100; ct++) {
            long sadd = System.nanoTime();
                s.add(rnd.nextInt(10));
            long eadd = System.nanoTime();
            tadd += (eadd - sadd);
        }
        System.out.println("Add time = " + tadd/100 + " ns");*/

        // s.show();
       /* long tdel = 0;
        for (int ctr = 0; ctr < 100; ctr++) {
            long sdel = System.nanoTime();
            s.remove();
            long edel = System.nanoTime();
            tdel += (edel - sdel);
        }
        System.out.println("Del time = " + tdel / 100 + " ns");
*/

        SimpleRev sR = new SimpleRev();
        long tadd2 = 0;
        for (int i = 0; i < n; i++) {
            sR.add(rnd.nextInt(n));
        }
        for(int ct = 0; ct < 100; ct++){
            long sadd2 = System.nanoTime();
            sR.remove();
            long eadd2 = System.nanoTime();
            tadd2 += (eadd2-sadd2);
        }
        //sR.show();
        System.out.println("Reverse del time = " + tadd2/100 + " ns");



    }


}
