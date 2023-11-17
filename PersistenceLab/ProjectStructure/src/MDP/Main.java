package MDP;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
    	Place p = new Place(1, "Tanger");
    	Place p2 = new Place(1, "Benguerir");
    	Place p3 = new Place(2, "Safi");
    	
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
    	
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("fr.properties");

        Properties langProps = new Properties();

        try {
            if (inputStream != null) {
                langProps.load(inputStream);

                String depS = langProps.getProperty("dep");
                String destS = langProps.getProperty("dest");

                System.out.println("Department: " + depS);
                System.out.println("Destination: " + destS);
            } else {
                System.err.println("Error: Unable to load properties file.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    	
    	
    }
}
