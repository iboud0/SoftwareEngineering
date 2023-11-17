package MDP;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaceDao extends AbstractDAOA{

	public int createPlace(Place p) {
		PreparedStatement pst = null;
        String sql = "insert into place (id, name) values (?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setLong(1, p.getId());
            pst.setString(2, p.getName());
            pst.executeUpdate();
        } catch (SQLException exp) {
            System.out.println(exp.getMessage());
        }
		return 1;
	}
	
	public Place findPlaceById(long id) {
		PreparedStatement pst = null;
        ResultSet rs;
        String sql = "select * from place where id= ?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setLong(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getLong("id") + ": " + rs.getString("name"));
                return new Place(rs.getLong("id"), rs.getString("name"));
            }
        } catch (SQLException exp) {
            System.out.println(exp.getMessage());
        }
        return null;
	}
	
	public boolean updatePlace(Place p) {
		PreparedStatement pst = null;
        String sql = "UPDATE place SET name= ? WHERE id= ?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, p.getName());
            pst.setLong(2, p.getId());
            pst.executeUpdate();
        } catch (SQLException exp) {
            System.out.println(exp.getMessage());
            return false;
        }
        return true;
	}
	
	public boolean removePlace(Place p) {
		PreparedStatement pst = null;
        String sql = "delete from place where id= ?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setLong(1, p.getId());
            pst.executeUpdate();
        } catch (SQLException exp) {
            System.out.println(exp.getMessage());
            return false;
        }
        return true;
	}
}
