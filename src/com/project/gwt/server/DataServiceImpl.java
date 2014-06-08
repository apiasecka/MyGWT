package com.project.gwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.project.gwt.client.DataService;
import com.project.gwt.shared.Data;

public class DataServiceImpl extends RemoteServiceServlet implements DataService {
	private static final long serialVersionUID = 1L;
	
	Data data = new Data(
		"Aleksandra Piasecka", 
		"Gdañsk", 
		"661 494 726", 
		"alexa1401@gmail.com", 
		"http://pourleplaisir72.p.o.pic.centerblog.net/o/43fa81b7.jpg"
	);
	
	public Data getData() {
		return data;
	}
	
	public void setData(Data dataReplace) {
		data.setName(dataReplace.getName());
		data.setAdress(dataReplace.getAdress());
		data.setPhone(dataReplace.getPhone());
		data.setEmail(dataReplace.getEmail());
		data.setPicture(dataReplace.getPicture());
	}
	
}
