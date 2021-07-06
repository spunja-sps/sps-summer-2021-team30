package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

@WebServlet("/user-info")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the value entered in the form and the timestamp.
    String textValue = Jsoup.clean(request.getParameter("user-input"), Whitelist.none());
    long timestamp = System.currentTimeMillis();

    // Print the value so you can see it in the server logs.
    System.out.println("This is what was submitted: " + textValue);

    // Create entity to store in Datastore
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("UserInfo");
    FullEntity userEntity = Entity.newBuilder(keyFactory.newKey())
                            .set("info", textValue)
                            .set("timestamp", timestamp)
                            .build();
    datastore.put(userEntity);

    // Redirect client back to main page
    response.sendRedirect("index.html");
  }
}