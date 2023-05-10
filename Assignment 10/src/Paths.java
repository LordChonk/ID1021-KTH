public class Paths {

    City[] path;
    int ptr;

    public Paths(){
        path = new City[55];
        ptr = 0;
    }

    public static void main(String[] args) {
        String[] fromArr = new String[]{"Malmö", "Malmö", "Malmö", "Malmö", "Malmö", "Malmö", "Malmö", "Malmö", "Malmö", "Malmö"};
        String[] toArr = new String[]{"Lund", "Hässleholm", "Värnamo", "Linköping", "Stockholm", "Uppsala", "Gävle", "Sundsvall", "Umeå", "Kiruna"};

        System.out.println(java.util.Arrays.toString(fromArr));
        for (int i = 0; i < 10; i++) {
            Integer dist = 0;
            long t0;
            long min = Long.MAX_VALUE;
            Map map = new Map("C:\\Users\\adria\\OneDrive\\Desktop\\KTH\\ID1021\\Assignment 10\\trains.csv");
            Integer max = 10000;
            Paths path = new Paths();
            long begin = System.nanoTime();
            dist = path.shortest(map.lookup(fromArr[i]), map.lookup(toArr[i]), max);
            long end = System.nanoTime();
            t0 = (end - begin);
            if (t0 < min) {
                min = t0;
            }
            if (dist != null) {
                System.out.println("shortest: between " + fromArr[i] + " and " + toArr[i] +" "+ dist + " min (" + (float)min/1_000 + " us)");
            } else {
                System.out.println("Beeger max needed");
            }

        }
    }
    private Integer shortest(City from, City to, Integer max) {
        if (max < 0)
            return null;
        if (from == to)
            return 0;

        Integer shrt = null;
        Connection connection;

        for (int j = 0; j < ptr; j++) {
            if (path[j].equals(from)){
                return null;
            }
        }
        path[ptr++] = from;

        for (int i = 0; i < from.neighbors.length; i++) {
            if (from.neighbors[i] != null) {
                connection = from.neighbors[i];
                Integer dist  =shortest(connection.city,to,max-connection.dist);
                if ((dist != null) && ((shrt==null) || (shrt > dist + connection.dist))){
                    shrt = dist + connection.dist;
                }
                if ((shrt != null) && (max > shrt)){
                    max = shrt;
                }
            }
        }
        path[ptr--] = null;
        return shrt;
    }


}
