public class Naive {

    private static Integer shortest(City from, City to, Integer max) {
        if (max < 0)
            return null;
        if (from == to)
            return 0;

        Integer shrt = null;

           for(int i = 0; i < from.neighbors.length; i++){
               if (from.neighbors[i] != null){
                   Connection conn = from.neighbors[i];
                   Integer dist = shortest(conn.city, to, max - conn.dist);
                   if((dist != null) && ((shrt == null) || (shrt > dist + conn.dist)))
                       shrt = dist + conn.dist;
                   if((shrt != null) && (max > shrt)){
                       max = shrt;
                   }
               }
            }
            return shrt;
        }

   /* private static Integer shortest(City from, City to, Integer max) {
        if (max < 0) {
            return null;
        }
        if (from == to) {
            return 0;
        }
        Integer shrt = null;
        for (int i = 0; i < from.getNeighbor().size(); i++) {
            if (from.getNeighbor().get(i) != null) {
                Connection conn = from.getNeighbor().get(i);
                Integer distance = shortest(conn.getConnectingCity(), to, max - conn.getDistance());
                if ((distance != null) && ((shrt == null) || (shrt > distance + conn.getDistance()))) {
                    shrt = distance + conn.getDistance();
                }
                if ((shrt != null) && (max > shrt)) {
                    max = shrt;
                }
            }
        }
        return shrt;
    }*/
    /*private static Integer shortest1(City from, City to, Integer max)
    {
        if (max < 0)
            return null;
        if (from == to)
            return 0;
        Integer shrt = null;
        int i = 0;
        while(i < from.neighbors.length)
        {
            Connection conn = from.neighbors[i++];
            Integer ret = shortest(conn.city, to, max-conn.dist);
            if(ret != null)
            {
                ret += conn.dist;
                if(shrt == null)
                    shrt = ret;
                else if(shrt.compareTo(ret) > 0)
                    shrt = ret;
            }
        }
        return shrt;
    }

    private static Integer shortest2(City from, City to, Integer max) {
        if (max < 0)
            return null;
        if (from == to)
            return 0;
        Integer shrt = null;
        for (int i = 0; i < from.neighbors.length; i++) {
            if (from.neighbors[i] != null) {
                Connection conn = from.neighbors[i];
                Integer totDist = shortest(conn.city, to, max-conn.dist);

                if (totDist != null && (shrt == null || (shrt > totDist + conn.dist))) {
                    shrt = totDist + conn.dist;
                }
            }
        }
        return shrt;
    }*/


        public static void main (String[]args){
            Map map = new Map("C:\\Users\\adria\\OneDrive\\Desktop\\KTH\\ID1021\\Assignment 10\\trains.csv");

            String from = "Göteborg";
            String to = "Umeå"; //to
            Integer max = 1000; //max



        /*String from = args[0];
        String to = args[1];
        Integer max = Integer.valueOf(args[2]);*/


            long t0 = System.nanoTime();
            Integer dist = shortest(map.lookup(from), map.lookup(to), max);
            long time = (System.nanoTime() - t0) / 1_000;
            System.out.println("shortest: " + dist + " min (" + time + " us)");
        }
    }


