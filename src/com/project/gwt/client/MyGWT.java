package com.project.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.project.gwt.shared.Data;

public class MyGWT implements EntryPoint {
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";
	
	private final DataServiceAsync dataService = GWT.create(DataService.class);
	private final LoginServiceAsync loginService = GWT.create(LoginService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		DOM.getElementById("edit").getStyle().setDisplay(Display.NONE);
		
	// Widok wizytówki
		final Image pictureEditLabel = new Image();
		final Label nameEditLabel = new Label();
		final Label adressEditLabel = new Label();
		final Label phoneEditLabel = new Label();
		final Label emailEditLabel = new Label();
		
		final Button loginButton = new Button("Zaloguj");
    
    
    // Elementy edycji wizytówki
		final Label nameLabel = new Label();
		nameLabel.setText("Imie i nazwisko");
		final TextBox nameField = new TextBox();
		
		final Label adressLabel = new Label();
		adressLabel.setText("Adres");
		final TextBox adressField = new TextBox();
	   
		final Label phoneLabel = new Label();
		phoneLabel.setText("Telefon");
	    final TextBox phoneField = new TextBox();
	    
	    final Label emailLabel = new Label();
	    emailLabel.setText("Email");
	    final TextBox emailField = new TextBox();
	    
	    final Label pictureLabel = new Label();
	    pictureLabel.setText("Obrazek (URL)");
	    final TextBox pictureField = new TextBox();
	    
	    final Label loginLabel = new Label();
	    loginLabel.setText("Login");
	    final TextBox loginField = new TextBox();
	    final Label passwordLabel = new Label();
	    passwordLabel.setText("Haslo");
	    final TextBox passwordField = new PasswordTextBox();
	    
	    final Button saveButton = new Button("Zapisz");
	    final Button logoutButton = new Button("Wyloguj");
   	
	    // Add the nameField and sendButton to the RootPanel
	    // Use RootPanel.get() to get the entire body element
	    RootPanel.get("image").add(pictureEditLabel);
	    RootPanel.get("text").add(nameEditLabel);
	    RootPanel.get("text").add(adressEditLabel);
	    RootPanel.get("text").add(phoneEditLabel);
	    RootPanel.get("text").add(emailEditLabel);
	    
	    RootPanel.get("login").add(loginLabel);
	    RootPanel.get("login").add(loginField);
	    RootPanel.get("login").add(passwordLabel);
	    RootPanel.get("login").add(passwordField);
	    RootPanel.get("login").add(loginButton);
	    
	    RootPanel.get("edit").add(nameLabel);
	    RootPanel.get("edit").add(nameField);
	    RootPanel.get("edit").add(adressLabel);
	    RootPanel.get("edit").add(adressField);
	    RootPanel.get("edit").add(phoneLabel);
	    RootPanel.get("edit").add(phoneField);
	    RootPanel.get("edit").add(emailLabel);
	    RootPanel.get("edit").add(emailField);
	    RootPanel.get("edit").add(pictureLabel);
	    RootPanel.get("edit").add(pictureField);
	    RootPanel.get("edit").add(saveButton);
	    RootPanel.get("edit").add(logoutButton);
	    
	    dataService.getData(new AsyncCallback<Data>() {
			public void onFailure(Throwable caught) {
			}

			public void onSuccess(Data result) {
				nameEditLabel.setText(result.getName());
				adressEditLabel.setText(result.getAdress());
				phoneEditLabel.setText(result.getPhone());
				emailEditLabel.setText(result.getEmail());
				pictureEditLabel.setUrl(result.getPicture());
			}
	    	
	    });
	    
	    logoutButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				loginField.setText("");
				passwordField.setText("");
				
				DOM.getElementById("edit").getStyle().setDisplay(Display.NONE);
				DOM.getElementById("card").getStyle().setDisplay(Display.BLOCK);
				DOM.getElementById("login").getStyle().setDisplay(Display.BLOCK);
				
				Notification notification = new Notification("Zostales wylogowany", true, true);
				notification.show();
			}
	    	
	    });
	    
	    saveButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				Data dataSave = new Data(nameField.getText(), adressField.getText(), phoneField.getText(), emailField.getText(), pictureField.getText() );
			
				dataService.setData(dataSave, new AsyncCallback<Void>(){
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					public void onSuccess(Void result) {
						// TODO Auto-generated method stub
						nameEditLabel.setText(nameField.getText());
						adressEditLabel.setText(adressField.getText());
						phoneEditLabel.setText(phoneField.getText());
						emailEditLabel.setText(emailField.getText());
						pictureEditLabel.setUrl(pictureField.getText());
						
						Notification notification = new Notification("Zapisano", true, true);
						notification.show();
					}
					
				});
			}
	    	
	    });
	    
	    loginButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				final String login = loginField.getText();
				final String password = passwordField.getText();
				
				loginService.checkLogin(login, password, new AsyncCallback<Boolean>(){

					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					public void onSuccess(Boolean result) {
						// TODO Auto-generated method stub
						if(result == true){
							nameField.setText(nameEditLabel.getText());
							adressField.setText(adressEditLabel.getText());
							phoneField.setText(phoneEditLabel.getText());
							emailField.setText(emailEditLabel.getText());
							pictureField.setText(pictureEditLabel.getUrl());
							
							DOM.getElementById("edit").getStyle().setDisplay(Display.BLOCK);
							DOM.getElementById("login").getStyle().setDisplay(Display.NONE);
							DOM.getElementById("card").getStyle().setDisplay(Display.NONE);
							
							Notification notification = new Notification("Zalogowano poprawnie", true, true);
							notification.show();
						} else {
							Notification notification = new Notification("Bledny login lub haslo!", true, true);
							notification.show();
						}
					}
					
				});
			}
	    	
	    });
	    

	    // Create the popup dialog box
	    /*
	    final DialogBox dialogBox = new DialogBox();
	    dialogBox.setText("Remote Procedure Call");
	    dialogBox.setAnimationEnabled(true);
	    final Button closeButton = new Button("Close");
	    // We can set the id of a widget by accessing its Element
	    closeButton.getElement().setId("closeButton");
	    final Label textToServerLabel = new Label();
	    final HTML serverResponseLabel = new HTML();
	    VerticalPanel dialogVPanel = new VerticalPanel();
	    dialogVPanel.addStyleName("dialogVPanel");
	    dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
	    dialogVPanel.add(textToServerLabel);
	    dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
	    dialogVPanel.add(serverResponseLabel);
	    dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
	    dialogVPanel.add(closeButton);
	    dialogBox.setWidget(dialogVPanel);
	    */

	}

}
