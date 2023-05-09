public class Main {
    public static void main(String[]args) {
        BinaryTree tree = new BinaryTree();
        tree.addLeaf(100, 1);
        tree.addLeaf(30, 1);
        tree.addLeaf(20, 1);
        tree.addLeaf(40, 1);
        tree.addLeaf(110, 1);
        tree.addLeaf(140, 1);
        tree.addLeaf(120, 1);
        tree.addLeaf(160, 1);
        tree.addLeaf(50, 1);
        tree.addLeaf(22, 1);
        tree.addLeaf(18, 1);
        tree.addLeaf(38, 1);
        tree.addLeaf(105, 1);
        tree.addLeaf(104, 1);
        tree.addLeaf(106, 1);

        for (int i : tree)
            System.out.println("Next value " + i);

        int[] nArray = new int[8];
        int ok = 100;
        for (int l = 0; l < nArray.length; l++) {
            nArray[l] = ok;
            ok = ok * 2;
        }
        System.out.println(java.util.Arrays.toString(nArray));

        long t0;
        int k = 10000;
        for (int n : nArray) {
            int[] sortedArray = new int[n];
            for (int i = 0; i < n; i++) {
                sortedArray[i] = i;
            }
            long min = Long.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                ArrayQueue testQ = new ArrayQueue();
                long begin = System.nanoTime();
                for (int i = 0; i < n; i++) {
                    testQ.add(i);
                }
                for (int i = 0; i < n; i++) {
                    testQ.poll();
                }
                long end = System.nanoTime();
                t0 = (end - begin);
                if (t0 < min) {
                    min = t0;
                }
            }
            System.out.println("Queue adding and polling " + (min));

        }
    }
}
