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

import lu.list.organization.model.Organization;
import lu.list.organization.util.DbUtil;

public class OrganizationDaoImpl implements OrganizationDao {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(OrganizationDaoImpl.class);
	
	@Override
	public void addOrganization(Organization organization) {
		String sql = "insert into organization(organization_name) values (?)";
		Connection connection = DbUtil.getConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, organization.getNameOrganization());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			LOGGER.debug(e.toString());
		}
	}

	@Override
	public List<Organization> getAllOrganization() {
		
		List<Organization> listOrganizations = new ArrayList<Organization>();
		
		String sql = "select * from organization";
		Connection connection = DbUtil.getConnection();
        
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Organization organization = new Organization();
				organization.setIdOrganization(rs.getInt("organization_id"));
				organization.setNameOrganization(rs.getString("organization_name"));
				listOrganizations.add(organization);
			}
		} catch (SQLException e) {
			LOGGER.debug(e.toString());
		}
		
		return listOrganizations;
	}

	@Override
	public Organization getOrganizationById(int id) {
		Organization organization = null;
		
		String sql = "select * from organization where organization_id = ?";
		Connection connection = DbUtil.getConnection();
        
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery(sql);

			while (rs.next()) {
				organization = new Organization();
				organization.setIdOrganization(rs.getInt("organization_id"));
				organization.setNameOrganization(rs.getString("organization_name"));
			}
		} catch (SQLException e) {
			LOGGER.debug(e.toString());
		}
		
		return organization;
	}

	@Override
	public void updateOrganization(Organization organization) {
		String sql = "UPDATE organization set organization_name = ? where organization_id = ?";
		Connection connection = DbUtil.getConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, organization.getNameOrganization());
			pstmt.setInt(2, organization.getIdOrganization());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			LOGGER.debug(e.toString());
		}
	}

}
