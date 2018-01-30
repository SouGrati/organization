package lu.list.organization.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lu.list.organization.model.Subject;
import lu.list.organization.util.DbUtil;

public class SubjectDaoImpl implements SubjectDao {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(SubjectDaoImpl.class);
	
	@Override
	public Subject login(Subject subject) {
		
		Subject user = null;
		String sql = "select * from subject where subject_name = ? and subject_password = ?";
		Connection connection = DbUtil.getConnection();
        
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, subject.getSubject_name());
			pstmt.setString(2, subject.getSubject_password());
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				user = new 	Subject();
				user.setSubject_id(rs.getInt("subject_id"));
				user.setAdmin(rs.getBoolean("is_admin"));
				user.setOrganization_id(rs.getInt("organization_id"));
				user.setSubject_name(rs.getString("subject_name"));
			}
		} catch (SQLException e) {
			LOGGER.debug(e.toString());
		}
		
		return user;
	}

	@Override
	public void addSubject(Subject subject) {
		String sql = "insert into subject(subject_name, subject_password, organization_id) values (?,?,?)";
		Connection connection = DbUtil.getConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, subject.getSubject_name());
			pstmt.setString(2, subject.getSubject_password());
			pstmt.setInt(3, subject.getOrganization_id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			LOGGER.debug(e.toString());
		}
		
	}

}
