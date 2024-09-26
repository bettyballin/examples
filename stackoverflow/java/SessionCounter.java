// Assuming this is the Java class that needs to be defined for the above XML snippet
// in a web.xml for a Java web application

package com.web;

import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionEvent;

public class SessionCounter implements HttpSessionListener {

    private static int activeSessions = 0;

    public void sessionCreated(HttpSessionEvent se) {
        activeSessions++;
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        if (activeSessions > 0)
            activeSessions--;
    }

    public static int getActiveSessions() {
        return activeSessions;
    }
}