package main.java.com.google.sps.servlets;
import java.util.*;
//import main.java.com.google.sps.dto.Resource;


import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Arrays;
import com.google.gson.Gson;

@WebServlet("/resource")
public class ResourceServlet extends HttpServlet {

  private static final List<String> resourceList = Arrays.asList(
      "Resource 1", 
      "Resource 2",
      "Resource 3", 
      "Resource 4");

  private static final String message_as_json = new Gson().toJson(resourceList);

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    //ArrayList<String> resourceList = ArrayList<String>();
    //Resource newResource = new Resource(1, "Invitation to Computer Science", "description", LocalDateTime.now());
//    public Resource(int id, String title, String description, LocalDateTime creationTime) {

    response.setContentType("application/json;");
    response.getWriter().println(message_as_json);
  }
}
