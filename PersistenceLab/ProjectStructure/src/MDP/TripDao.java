package MDP;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TripDao extends AbstractDAOA{
	
	String depS = "from";
	String destS = "to";
	
	public int createTrip(Trip t) {
		PreparedStatement pst = null;
        String sql = "insert into trip (id, departure, destination, price) values (?,?,?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setLong(1, t.getId());
            pst.setLong(2, t.getDeparture().getId());
            pst.setLong(3, t.getDestination().getId());
            pst.setDouble(4, t.getPrice());
            pst.executeUpdate();
        } catch (SQLException exp) {
            System.out.println(exp.getMessage());
        }
		return 1;
	}
	
	public Trip findTripById(long id) {
		PreparedStatement pst = null;
        ResultSet rs;
        String sql = "select * from trip where id= ?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setLong(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
            	PlaceDao pDao = new PlaceDao();
                Place dep = pDao.findPlaceById(rs.getLong("departure"));
                Place dest = pDao.findPlaceById(rs.getLong("destination"));
                System.out.println(rs.getLong("id") + ": " + depS + " " + dep.getName() + " " + destS + " " + dest.getName());
                return new Trip(rs.getLong("id"), dep, dest, rs.getDouble("price"));
            }
        } catch (SQLException exp) {
            System.out.println(exp.getMessage());
        }
        return null;
	}
	
	public boolean removeTrip(Trip t) {
		PreparedStatement pst = null;
        String sql = "delete from trip where id= ?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setLong(1, t.getId());
            pst.executeUpdate();
        } catch (SQLException exp) {
            System.out.println(exp.getMessage());
            return false;
        }
        return true;
	}
}
