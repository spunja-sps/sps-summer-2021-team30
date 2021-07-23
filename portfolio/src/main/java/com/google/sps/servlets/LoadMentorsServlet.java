package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.gson.Gson;
import com.google.sps.dto.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet responsible for listing tasks. */
@WebServlet("/load-mentors")
public class LoadMentorsServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    Query<Entity> query =
        Query.newEntityQueryBuilder().setKind("User").setOrderBy(OrderBy.desc("firstName")).build();
    QueryResults<Entity> results = datastore.run(query);

    List<User> mentors = new ArrayList<>();
    while(results.hasNext()) {
      Entity entity = results.next();
      if (entity.getString("userType").equals("mentor")) {
        long id = entity.getKey().getId();
        String firstName = entity.getString("firstName");
        String lastName = entity.getString("lastName");
        String email = entity.getString("email");
        String userType = entity.getString("userType");

        System.out.println(firstName + " " + lastName + " is a " + userType + "!");
        User user = new User(id, firstName, lastName, email, null, userType);
        mentors.add(user);
      }
    }

    Gson gson = new Gson();
    response.setContentType("application/json;");
    response.getWriter().println(gson.toJson(mentors));
  }
}