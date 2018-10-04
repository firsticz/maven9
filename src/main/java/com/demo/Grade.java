package com.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bson.Document;

import com.google.gson.Gson;

@Path("/grade")
public class Grade {
	
	@GET
	@Path("/calculate/{score}")
	@Produces(MediaType.APPLICATION_JSON)
	public String calculate(@PathParam("score")int score) {
		Calculate cal = new Calculate();
		cal.setScore(score);
		String grade = cal.calculateGrade();
		
		Document doc = new Document();
		doc.append("grade", grade);
		Gson gson = new Gson();
		
		return gson.toJson(doc);
		
	}
}
