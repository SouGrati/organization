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
		String sqlOrg = "insert into organization(organization_name) values (?)";
		String sqlCoalition = "insert into coalition(coalition_name) values (?)";
		String sqlParticipatesIn = "insert into participatesIn(organization_id,coalition_id) values (?,?)";
		Connection connection = DbUtil.getConnection();
		try {
			int idOrg = 0, idCoa = 0;
			// insert Organization
			PreparedStatement pstmt = connection.prepareStatement(sqlOrg);
			pstmt.setString(1, organization.getNameOrganization());
			pstmt.executeUpdate();
			ResultSet rsOrg = pstmt.getGeneratedKeys();
			if (rsOrg.next()) {
				idOrg = rsOrg.getInt(1);
			}
			// insert Coalition
			PreparedStatement pstmt2 = connection.prepareStatement(sqlCoalition);
			pstmt2.setString(1, organization.getCoalition().getCoalitionName());
			pstmt2.executeUpdate();
			ResultSet rsCoa = pstmt2.getGeneratedKeys();
			if (rsCoa.next()) {
				idCoa = rsCoa.getInt(1);
			}
			// insert ParticipatesIn (organization_id, coalition_id)
			if(idOrg == 0 || idCoa == 0){
				throw new SQLException("Organization or Coalition not inserted correctly.");
			} else {
				PreparedStatement pstmt3 = connection.prepareStatement(sqlParticipatesIn);
				pstmt3.setInt(1, idOrg);
				pstmt3.setInt(2, idCoa);
				pstmt3.executeUpdate();
			}
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
