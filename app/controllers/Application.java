package controllers;

import java.util.*;

import models.*;


import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import play.Logger;
import play.Play;
import play.mvc.Controller;
import play.mvc.Http.Header;
import play.mvc.Scope.Params;
import play.mvc.With;


public class Application extends Controller {

    public static void index() {
        render();
    }

	public static void ticketAuth() { 
		Params params = request.params;
		String user = params.get("user");
		String ticket = params.get("ticket");
		if(user==null || ticket==null) {
			renderText("{ \"@Success\": \"fail\"," +
					"\"@ErrorCode\": \"-1\" \"}");

		}
		if((user.length()==0) || (ticket.length()==0)) {
			renderText("{ \"@Success\": \"fail\"," +
					"\"@ErrorCode\": \"-1\" }");
		}
				
		if("error2".equalsIgnoreCase(ticket)) {
			renderText("{ \"@Success\": \"fail\"," +
					"\"@ErrorCode\": \"-3\" ," +
					"\"@ErrorText\": \"Ticket validated by George at 30/1/2015 19:15\" }");			
		}
		if(ticket.toUpperCase().indexOf("ERROR")!=-1) {
			renderText("{ \"@Success\": \"fail\"," +
					"\"@ErrorCode\": \"-2\" ," +
					"\"@ErrorText\": \"Invalid Ticket\" }");						
		}
		
		renderText("{ \"@Success\": \"true\"," +
				"\"@ticketHolder\": \"Spongebob\" }");
	}
}