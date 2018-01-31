package lu.list.organization.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lu.list.organization.model.OObject;
import lu.list.organization.util.DbUtil;

public class ObjectDaoImpl implements ObjectDao {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(ObjectDaoImpl.class);
	
	@Override
	public void addObject(OObject object) {
		String sql = "insert into object(object_name, organization_id, object_path) values (?,?,?)";
		Connection connection = DbUtil.getConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, object.getObject_name());
			pstmt.setInt(2, object.getOrganization_id());
			pstmt.setString(3, object.getObject_path());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			LOGGER.debug(e.toString());
		}
	}

	@Override
	public List<OObject> getAllObjects() {
		List<OObject> listObjects = new ArrayList<OObject>();
		
		String sql = "select * from object";
		Connection connection = DbUtil.getConnection();
        
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				OObject object = new OObject();
				object.setObject_id(rs.getInt("object_id"));
				object.setObject_name(rs.getString("object_name"));
				object.setObject_path(rs.getString("object_path"));
				object.setOrganization_id(rs.getInt("organization_id"));
				listObjects.add(object);
			}
		} catch (SQLException e) {
			LOGGER.debug(e.toString());
		}
		
		return listObjects;
	}

	@Override
	public OObject getObjectById(int idObject) {
		OObject object = null;
		
		String sql = "select * from object where object_id = ?";
		Connection connection = DbUtil.getConnection();
        
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, idObject);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				object = new OObject();
				object.setObject_id(idObject);
				object.setObject_name(rs.getString("object_name"));
				object.setObject_path(rs.getString("object_path"));
				object.setOrganization_id(rs.getInt("organization_id"));
			}
		} catch (SQLException e) {
			LOGGER.debug(e.toString());
		}
		
		return object;
	}

}
