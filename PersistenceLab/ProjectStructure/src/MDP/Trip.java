package MDP;

public class Trip {
	private long id;
	private Place departure;
	private Place destination;
	private double price;
	
	public Trip(long id, Place departure, Place destination, double price) {
        this.id = id;
        this.departure = departure;
        this.destination = destination;
        this.price = price;
    }
	
	public long getId() {
    	return id;
    }
    
    public void setId(long id) {
    	this.id = id;
    }
    
    public Place getDeparture() {
    	return departure;
    }
    
    public void setDeparture(Place departure) {
    	this.departure = departure;
    }
    
    public Place getDestination() {
    	return destination;
    }
    
    public void setDestination(Place destination) {
    	this.destination = destination;
    }
    
    public double getPrice() {
    	return price;
    }
    
    public void setPrice(double price) {
    	this.price = price;
    }
    
	@Override
	public String toString() {
		return "Trip " + id + ": from " + departure + " to " + destination;
	}
}
