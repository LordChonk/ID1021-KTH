import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Zip {

    Node[] data;
    int max;
    public class Node {
        public String code;
        public String name;
        public Integer pop;

        public Node (String code, String name, Integer pop){
            this.code = code;
            this.name = name;
            this.pop = pop;
        }
        public String getCode(){
            return this.code;
        }
        public String getName(){
            return this.name;
        }
        public Integer getPop(){
            return this.pop;
        }
    }
    public Zip(String file) {
        data = new Node[10000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                //String code = Integer.valueOf(row[0].replaceAll("\\s", ""));
                data[i++] = new Node(row[0], row[1], Integer.valueOf(row[2]));
                //data[i++] = new Node(code, row[1], Integer.valueOf(row[2]));
            }
            max = i-1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }

    }

    public String linLook(String code){
        for(int i = 0; i < data.length; i++){
            if(code.equals(data[i].code)){
                return data[i].name;
            }
        }
        return null;
    }
    public String binLook(String zip) {
        int min = 0;
        int max = this.max;
        while (true) {
            int i = (min + max) / 2;
            int cmp = zip.compareTo(data[i].code);// returns 0 if they are equal
            if (cmp == 0) {
                return data[i].name;
            }
            if (cmp > 0 && i < max) {
                min = i + 1;
                continue;
            }
            if (cmp < 0 && i > min) {
                max = i - 1;
                continue;
            }
            break;
        }
        return null;
    }
}
