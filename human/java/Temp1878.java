// Directory structure
src
  main
    java
      com
        example
          backend
            Backend.java
    resources
  webapp
    resource
      index.html

// Backend.java
package com.example.backend;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class Backend extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String htmlFilePath = getServletContext().getRealPath("/resource/index.html");
        String htmlContent = new String(Files.readAllBytes(Paths.get(htmlFilePath)));
        response.setContentType("text/html");
        response.getWriter().write(htmlContent);
    }
}

// index.html
<!DOCTYPE html>
<html>
<head>
    <title>My Web App</title>
</head>
<body>
    <h1>Welcome to My Web App</h1>
</body>
</html>