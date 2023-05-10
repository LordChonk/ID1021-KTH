import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Map {
        private City[] cities;
        private final int mod = 541;

    public City[] getCities() {
        return cities;
    }
    public City lookup(String name){
        Integer i = hash(name);
        while(cities[i] != null){

            if (this.cities[i].name.equals(name))
                return cities[i];
            i++;
        }
            cities[i] = new City(name);
        return  cities[i];
    }
    public Map(String file) {
            cities = new City[mod];
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] row = line.split(",");
                    Integer dist = Integer.valueOf(row[2]);

                    City one = lookup(row[0]);
                    City two = lookup(row[1]);

                    one.addConn(two, dist);
                    two.addConn(one, dist);
                }
            } catch (Exception e) {
                System.out.println(" file " + file + " not found or corrupt");
            }
        }
    private Integer hash(String name) {
        int hash = 7;
        for (int i = 0; i < name.length(); i++) {
            hash = (hash*31 % mod) + name.charAt(i);
        }
        return hash % mod;
    }

    }

