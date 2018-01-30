package lu.list.organization.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
