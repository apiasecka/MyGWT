package com.project.gwt.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.project.gwt.shared.Data;

@RemoteServiceRelativePath("edit")
public interface DataService extends RemoteService {	
	Data getData();
	void setData(Data data);
}
