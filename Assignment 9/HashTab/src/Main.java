import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        int m = 25000;
        Hash zop = new Hash("C:/Users/adria/OneDrive/Desktop/KTH/ID1021/Assignment 9/postnummer.csv", m);
        Zip zip = new Zip("C:/Users/adria/OneDrive/Desktop/KTH/ID1021/Assignment 9/postnummer.csv");
        Zap zap = new Zap("C:/Users/adria/OneDrive/Desktop/KTH/ID1021/Assignment 9/postnummer.csv");
        hashZip hZip = new hashZip("C:/Users/adria/OneDrive/Desktop/KTH/ID1021/Assignment 9/postnummer.csv", m);
        long t11115 = 0;
        long t98499 = 0;
        long t11115bin = 0;
        long t98499bin = 0;
        long t11115arr = 0;
        long t98499arr = 0;
        long t1 = 0;
        long t9 = 0;
        long t2 = 0;
        long t8 = 0;
        for (int ct = 0; ct < 100; ct++) {


            /*long s11115 = System.nanoTime();
            System.out.println(zip.linLook("111 15"));
            long e11115 = System.nanoTime();
            t11115 += (e11115 - s11115);


            long s98499 = System.nanoTime();
            System.out.println(zip.linLook("984 99"));
            long e98499 = System.nanoTime();
            t98499 += (e98499 - s98499);


            long s11115bin = System.nanoTime();
            System.out.println(zip.binLook("111 15"));
            long e11115bin = System.nanoTime();
            t11115bin += (e11115bin - s11115bin);


            long s98499bin = System.nanoTime();
            System.out.println(zip.binLook("984 99"));
            long e98499bin = System.nanoTime();
            t98499bin += (e98499bin - s98499bin);*/


            /*long s11115arr = System.nanoTime();
            System.out.println(zap.arrLook(11115));
            long e11115arr = System.nanoTime();
            t11115arr += (e11115arr - s11115arr);

            long s98499arr = System.nanoTime();
            System.out.println(zap.arrLook(98499));
            long e98499arr = System.nanoTime();
            t98499arr += (e98499arr - s98499arr);*/

            long s2 = System.nanoTime();
            System.out.println(hZip.lookup(11115));
            long e2 = System.nanoTime();
            t2 += (e2 -s2);

            long s8 = System.nanoTime();
            System.out.println(hZip.lookup(98499));
            long e8 = System.nanoTime();
            t8 += (e8 -s8);

            long s1 = System.nanoTime();
            System.out.println(zop.lookup(11115));
            long e1 = System.nanoTime();
            t1 += (e1 -s1);


            long s9 = System.nanoTime();
            System.out.println(zop.lookup(98499));
            long e9 = System.nanoTime();
            t9 += (e9-s9);
        }
        System.out.println("Avg. lookup time for 111 15 = " + t11115/100 + " ns");
        System.out.println("Avg. lookup time for 984 99 = " + t98499/100 + " ns");
        System.out.println("Avg. bin lookup time for 111 15 = " + t11115bin/100 + " ns");
        System.out.println("Avg. bin lookup time for 984 99 = " + t98499bin/100 + " ns");
        System.out.println("Avg. arr lookup time for 111 15 = " + t11115arr/100 + " ns");
        System.out.println("Avg. arr lookup time for 984 99 = " + t98499arr/100 + " ns");
        System.out.println("Avg. hash bucket 1 lookup time for 111 15 = " + t2/100 + " ns");
        System.out.println("Avg. hash bucket 1 lookup time for 984 99 = " + t8/100 + " ns");


        System.out.println("Avg. hash bucket 2 lookup time for 111 15 = " + t1/100 + " ns");
        System.out.println("Avg. hash bucket 2 lookup time for 984 99 = " + t9/100 + " ns");

        //hZip.collisions(m);
       /* System.out.println(hZip.nrOfCollisions());
        System.out.println(hZip.lookup(11115));
        System.out.println(zop.lookup(11115));

        zop.countStepsInLookup();*/
        //hZip.printKeys();
        //hZip.collisions(m);
    }
}