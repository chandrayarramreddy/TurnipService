package com.miracle.restservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.miracle.bean.TurnipBean;
import com.miracle.service.ITurnipService;
import com.miracle.service.TurnipServiceImpl;

/*
   http://localhost:9080/TurnipService/rest/dashBoardInfo/customersInfo

*/
@Path("/dashBoardInfo")
public class TurnipRestService {
	Response response = null;
	TurnipBean bean = null;
	ITurnipService service = null;
	JSONObject personsInJSon = null;
	JSONArray jsonArray = new JSONArray();
	List<TurnipBean> list = null;
	List<String> samplelist = null;
	// List<TurnipBean> orgList=null;
	final static Logger logger = Logger.getLogger(TurnipRestService.class);

	@GET
	@Path("/customersInfo")
	@Produces(MediaType.APPLICATION_JSON)
	// @Consumes(MediaType.TEXT_PLAIN)
	//public JSONObject getCustomerInfo(@QueryParam("vendorId") int vendorId) throws JSONException {
		public JSONObject getCustomerInfo(@QueryParam("vendor_id") int vendor_id) throws JSONException {
		
		bean = new TurnipBean();
		// JSONObject responseDetailsJson = new JSONObject();
		service = new TurnipServiceImpl();
		personsInJSon = new JSONObject();
	/*	System.out.println(vendorId);
		bean.setVendor_Id(vendor_Id);   */
		System.out.println(vendor_id);
		bean.setVendor_Id(vendor_id);
		ITurnipService ser = new TurnipServiceImpl();
		list = ser.getVendorCustomersList(bean);
		int i = 0;

		for (TurnipBean p : list) {
			
			JSONObject formDetailsJson = new JSONObject();
			// formDetailsJson.put("id", p.getAccountId());
			formDetailsJson.put("CompName", p.getCustomerName());
			jsonArray.put(i, formDetailsJson);
			i++;
		}
		personsInJSon.put("", jsonArray);// Here you can see the data in json
											// format

		System.out.println("result :::::" + personsInJSon);
		return personsInJSon;

	}

}