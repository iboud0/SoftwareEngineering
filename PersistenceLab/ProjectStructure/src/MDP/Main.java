package MDP;

public class Main {
    public static void main(String[] args) {
    	Place p = new Place(1, "Tanger");
    	Place p2 = new Place(2, "Benguerir");
    	Place p3 = new Place(3, "Safi");
    	
    	PlaceDao pDao = new PlaceDao();
    	
    	pDao.createPlace(p);
    	pDao.findPlaceById(1);
    	pDao.updatePlace(p2);
    	pDao.findPlaceById(1);
    	pDao.removePlace(p2);
    	pDao.findPlaceById(1);
    	
    	pDao.createPlace(p);
    	pDao.createPlace(p3);
    	
    	Trip t = new Trip(1, p, p3, 133.3);

    	TripDao tDao = new TripDao();
    	
    	tDao.createTrip(t);
    	tDao.findTripById(1);
    	tDao.removeTrip(t);
    	
    	
    }
}
