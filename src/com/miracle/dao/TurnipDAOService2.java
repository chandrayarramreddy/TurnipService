package com.miracle.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.miracle.bean.TurnipBean;
import com.miracle.util.Constants;
import com.sun.istack.logging.Logger;

public class TurnipDAOService2 {

	static Logger log = Logger.getLogger(TurnipDAOService2.class);
	private ResultSet rs = null;
	private Connection connection = null;
	private java.sql.PreparedStatement preparedStatement;
	List<TurnipBean> resultList = null;
	List<TurnipBean> orgList = null;
	TurnipBean bean = null;

	public List<TurnipBean> getVendorCustomersList(TurnipBean bean) {


		// DBConnection conn= new DBConnection();
		connection = DBConnection.getDbConnection();
		resultList = new ArrayList<TurnipBean>();
		try {
			preparedStatement = connection.prepareStatement(Constants.VENDOR_CUSTOMER_LIST);
			preparedStatement.setInt(1, bean.getVendor_Id());
			rs = preparedStatement.executeQuery();
			resultList = customerResultSet(rs);
			System.out.println("customerList : : " + resultList.size());

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBConnection.close(connection, preparedStatement, rs);
		}

		//return resultList;

	
		return resultList;
	}

	private List<TurnipBean> customerResultSet(ResultSet resultSet) throws Exception {
		resultList = new ArrayList<TurnipBean>();
		while (resultSet.next()) {
			bean = new TurnipBean();
			bean.setAccountId(resultSet.getInt(Constants.ACCOUNT_ID));
			bean.setCustomerId(resultSet.getInt(Constants.CUSTOMER_ID));
			bean.setCustomerName(resultSet.getString(Constants.CUSTOMER_NAME));
			bean.setStatus(resultSet.getString(Constants.STATUS));
			bean.setTierID(resultSet.getInt(Constants.VENDOR_TIER_ID));
			resultList.add(bean);
		}
		return resultList;
	}
	public List<TurnipBean> getCustomerVendorList(TurnipBean bean) {
		return orgList;
	}

	private List<TurnipBean> vendorResultSet(ResultSet resultSet) throws Exception {
		return orgList;
	}

	public List<TurnipBean> getOrganizationList(TurnipBean bean) {
		return orgList;
	}

	private List<TurnipBean> orgResultSet(ResultSet resultSet) throws Exception {
		return orgList;
	}

	public List<TurnipBean> getResourcesInfo(TurnipBean bean) {
		return orgList;
	}

	/*
	 * SELECT distinct
	 * acc.account_name,req.no_of_resources,proj.proj_req_skillset,req.
	 * req_skills,req.req_name,req.requirement_id,proj.acc_id,proj.project_id" +
	 * "pro.proj_name,proj.proj_status,req.jdid,req.req_type,req.req_status"
	 */

	private List<TurnipBean> resourcesResultSet(ResultSet resultSet) throws Exception {
		return orgList;
	}

	public List<String> getCustomerVendorList() {

		List<String> s = new ArrayList<String>();
		s.add("Walmart");
		s.add("IBM");
		s.add("Ford");
		System.out.println(s);
		return s;
	}

}
