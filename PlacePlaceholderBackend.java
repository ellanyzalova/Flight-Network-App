public class PlacePlaceholderBackend {
        public String destination;
        public String startingCity;
        public int cost;
        public int distance;


        public PlacePlaceholderBackend(String startingCity, String destination, int cost, int distance) {
                this.destination = destination;
                this.cost = cost;
                this.distance = distance;
                this.startingCity = startingCity;
        }

    public String getStartingCity(String startingCity) {
        return this.startingCity;
    }
    
        public String getDestination(String destination)
        {
                return this.destination;
        }

        public int getCost(int cost)
        {
                return this.cost;
        }

        public int getDistance(int distance)
        {
                return this.distance;
        }


}