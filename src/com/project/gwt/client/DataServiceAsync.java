package com.project.gwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.project.gwt.shared.Data;

public interface DataServiceAsync {	
	void getData(AsyncCallback<Data> callback);
	void setData(Data data, 
			AsyncCallback<Void> callback);
}