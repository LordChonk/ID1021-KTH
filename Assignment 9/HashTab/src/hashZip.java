import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

public class hashZip {
    Node[] data;
    int mod;
    int[] keys;
    int max;

    private class Node {
        private Integer code;
        private String name;
        private Integer pop;
        private Node next;

        public Node(Integer code, String name, Integer pop) {
            this.code = code;
            this.name = name;
            this.pop = pop;
            this.next = null;
        }
    }

    public hashZip(String file, int mod) {
        this.mod = mod; // save the modulo so that it can be used between methods
        data = new Node[mod]; // make the data array that will hold the nodes the size of modulo that will be
        // used to hash the keys.
        this.keys = new int[9676];// the csv file is 9,675 lines
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            int code = 0;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                code = Integer.parseInt(row[0].replaceAll("\\s", ""));
                bucket(code, new Node(code, row[1], Integer.valueOf(row[2])));
                // row[0] is code, row[1] is name and row[2] is population
                this.keys[i++] = code;

            }
            max = i - 1; // max is number of zip nodes
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    private void bucket(Integer code, Node entry) {
        Integer key = code % this.mod; // convert the zip code to a simple hash using modulo
        Node focus = this.data[key];
        Node prev = null;

        while (focus != null) {// if there already is a node placed at the hash index we check if they are the
            // same and if they are we replace the found entry
            if (code.equals(focus.code)) {
                focus = focus.next; // replace the found entry
                break;
            }
            prev = focus;
            focus = focus.next;
        }
        if (prev != null) {
            prev.next = entry;
        } else {
            data[key] = entry;
        }
        entry.next = focus;
    }

    public String lookup(Integer key) {
        Integer index = key % this.mod;
        Node current = data[index];
        while (current != null) {
            if (key.equals(current.code))
                return current.name;
            current = current.next;
        }
        return null;
    }

    public void collisions(int mod) {
        int[] data = new int[mod];
        int[] cols = new int[10];
        for (int i = 0; i < max; i++) {
            Integer index = keys[i] % mod;
            cols[data[index]]++;
            data[index]++;
        }
        System.out.print(mod);
        for (int i = 0; i < 10; i++) {
            System.out.print("\t" + cols[i]);
        }
        System.out.println();
    }

    public int nrOfCollisions() {
        Set<Integer> store = new HashSet<Integer>();
        int count = 0;
        for (int i = 0; i < keys.length; i++) {

            if (store.add(keys[i] % this.mod) == false) {
                count++;
                // System.out.println("Duplicate element found : " + keys[i]);
            }
        }
        return count;
    }
}