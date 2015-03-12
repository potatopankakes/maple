package com.gnoras.maple.web.services;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/family")
public class FamilyServiceImpl {
	
	@POST
	@Produces("application/json")
	@Path("/createforparent")
    public String createFamilyForParent(
			@FormParam("famName") String familyName,
			@FormParam("parName") String parentName,
			@FormParam("parEmail") String parentEmail,
			@FormParam("parPassword") String parentPassword,
			@FormParam("offerId") int offerId
		) 
	{
		try 
		{
			// 
			
			// validate the input values
			
			// create entries in database
				// create quota entry by copying offering's product plan's limits into new row in quota table
				// create account entry
//need to work this out  still... purchases?  no state on purchase?
// set account state to payment pending... if price != 0.00
				// else set account to ready (no user active?) or to user
				//
				// create account_product_plan entry, if no payment pending
				//
				// create email_address entry
				// create user entry
				// create email_verification entry
				//
				// create parent entry
				// create family entry
				// create family_parent entry
				
			// return the new plan id
			return "{ \"result\":\"ack\" }";
		}
		catch (Exception e)
		{
			// todo: log the exception
			
			// return the error for now... todo: remove exception
			return "{ \"result\":\"nak\", \"error\":\"" + e.toString() + "\" }";
		}
    }
	
}
