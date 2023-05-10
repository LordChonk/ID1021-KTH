import java.util.LinkedList;

public class City {

    String name;
    Connection[] neighbors;
    Integer pt = 0;

    public City(String name){
        this.name = name;
        neighbors = new Connection[10];
    }
    /*public void addConn(City city, int dist){
        for(int i = 0; i < neighbors.length; i++){
            if(neighbors[i] == null){
                neighbors[i] = new Connection(city, dist);
                return;
            }
        }
    }*/
    public void addConn(City city, Integer dist){
        //bigger();
       while(neighbors[pt] != null) {
           pt++;
       }
        neighbors[pt++] = new Connection(city, dist);
    }
    //public void bigger(){

      //  }

        public String getName(){
            return this.name;
    }


   /* public LinkedList<Connection> getNeighbor() {
        return this.neighbors;
    }*/
}

