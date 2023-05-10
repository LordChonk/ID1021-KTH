public class Connection {

    City city;
    Integer dist;

    public Connection(City city, Integer dist) {
          this.city = city;
          this.dist = dist;
    }
    public City getConnectingCity() {
        return this.city;
    }

    public Integer getDistance() {
        return this.dist;
    }
}
    //:

