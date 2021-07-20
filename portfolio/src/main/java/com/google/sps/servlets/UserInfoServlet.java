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
public class UserInfoServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the values entered in the user sign-up page.
    String firstName = Jsoup.clean(request.getParameter("first_name"), Whitelist.none());
    String lastName = Jsoup.clean(request.getParameter("last_name"), Whitelist.none());
    String email = Jsoup.clean(request.getParameter("email"), Whitelist.none());
    String password = Jsoup.clean(request.getParameter("password"), Whitelist.none());
    String userType = Jsoup.clean(request.getParameter("user_type"), Whitelist.none());
    long timestamp = System.currentTimeMillis();

    // Print the value so you can see it in the server logs.
    System.out.println("This is the first name: " + firstName);
    System.out.println("This is the last name: " + firstName);
    System.out.println("This is the email: " + firstName);
    System.out.println("This is the password: " + firstName);
    System.out.println("This is the userType: " + firstName);

    // Create entity to store in Datastore
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("User");
    FullEntity userEntity = Entity.newBuilder(keyFactory.newKey())
                            .set("firstName", firstName)
                            .set("lastName", lastName)
                            .set("email", email)
                            .set("password", password)
                            .set("userType", userType)
                            .build();
    datastore.put(userEntity);

    // Redirect client back to main page
    response.sendRedirect("index.html");
  }
}
