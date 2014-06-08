package com.project.gwt.client;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;

public class Notification extends PopupPanel {

    public Notification(String text, boolean autoHide, boolean modal) {
        super(autoHide, modal);
        setWidget(new Label(text));
    }

    void show(int delayMilliseconds) {
        show();
        Timer t = new Timer() {
            @Override
            public void run() {
                Notification.this.hide();
            }
        };
    }
}