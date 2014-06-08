package com.project.gwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoginServiceAsync {
	void checkLogin(String login, String password,
			AsyncCallback<Boolean> callback);

}
