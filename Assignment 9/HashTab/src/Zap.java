import java.io.BufferedReader;
import java.io.FileReader;

public class Zap {
    Node[] data;
    int max;
    public class Node {
        public int code;
        public String name;
        public Integer pop;

        public Node (int code, String name, Integer pop){
            this.code = code;
            this.name = name;
            this.pop = pop;
        }
        public int getCode(){
            return this.code;
        }
        public String getName(){
            return this.name;
        }
        public Integer getPop(){
            return this.pop;
        }
    }
    public Zap(String file) {
        data = new Zap.Node[100000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                int code = Integer.valueOf(row[0].replaceAll("\\s", ""));
                //data[i++] = new Zip.Node(row[0], row[1], Integer.valueOf(row[2]));
                data[code] = new Node(code, row[1], Integer.valueOf(row[2]));
            }
            max = i-1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }
        public String arrLook(int code){
        return this.data[code].name;
        }
}
