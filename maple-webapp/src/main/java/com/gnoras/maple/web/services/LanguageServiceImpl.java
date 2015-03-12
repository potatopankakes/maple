package com.gnoras.maple.web.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.gnoras.maple.core.interfaces.ILanguageSubsystem;
import com.gnoras.maple.dal.model.interfaces.ILanguage;
import com.gnoras.maple.web.results.SuccessResponse;

import flexjson.JSONSerializer;

@Path("/language")
public class LanguageServiceImpl {
	
	private ILanguageSubsystem ls;

	public void setLanguageSubsystem(ILanguageSubsystem value) {
		ls = value;
	}

	@GET
	@Produces("application/json")
	@Path("/list")
    public String listLanguages(
		) 
	{
		JSONSerializer resultSerializer = new JSONSerializer().exclude("*.class", "*.classType");
		List<ILanguage> languages = ls.getLanguages();
		return resultSerializer.serialize(new SuccessResponse(languages)); 
	}
}
