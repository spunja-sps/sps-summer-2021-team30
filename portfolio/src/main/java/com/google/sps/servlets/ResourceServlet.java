package main.java.com.google.sps.servlets;
import java.util.*;
import com.google.sps.dto.Resource;
//import main.java.com.google.sps.dto.Resource;
//import main.java.com.google.sps.dto.Resource;

import java.time.LocalDateTime;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import com.google.gson.Gson;

@WebServlet("/resource")
public class ResourceServlet extends HttpServlet {

  
//  resourceTest[0] = newResource;
  //resourceList.add(newResource);    


  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    
    // Getting Started
    ArrayList<Resource> resourceList = new ArrayList<>();
    resourceList.add(new Resource(1, 
        "University of Helsinki Intro Course",
        "Great comprehensive course that not only teaches you the Java language but also introduces you to computer science as a whole while developing key problem-solving skills. This is recommended if you have a good amount of spare time and enjoy tight structure and assignments, as it is a full introductory college course. Consistent time spent is emphasized for best results.", 
        LocalDateTime.now()));

    resourceList.add(new Resource
        (2, 
        "Crash Course",
        "If you have been on YouTube, then you probably know about the various Crash Course series. If not, then these videos, each around ten minutes in length, are very great fun. While these videos won’t teach you all the necessary skills you need to be a proficient programmer, they are phenomenal if you do not have much time and would like to take a peek into various fields of computer science without consulting the aforementioned textbook.", 
        LocalDateTime.now()));

    resourceList.add(new Resource(3, 
        "Invitation to Computer Science",
        "Though we will not reference too many textbooks on this page, here is one that is commonly used in many introductory courses. While you can learn code from it, it does a great job of giving you a sample of many different fields in computer science, giving you an opportunity to challenge yourself while also discovering new interests. The downside to this resource is that it is an expensive textbook. However, you can probably find this wherever you get your textbooks for reasonable, or in some cases, absent prices.", 
        LocalDateTime.now())); 


    // Java Development
    resourceList.add(new Resource
        (4, 
        "Big Java: Early Objects",
        "If you are someone who enjoys learning through a textbook, then this is a great resource. The breadth of problems provided in this book is particularly valuable, since some problems are accessible and understandable for beginners with no experience, while others can be challenging even for those who have prior background. The downside to this resource is that it is an expensive textbook. However, you can probably find this wherever you get your textbooks for reasonable, or in some cases, absent prices.", 
        LocalDateTime.now()));

    resourceList.add(new Resource
        (5, 
        "Derek Bana's Java Videos",
        "If you are a visual learner, then this is a resource for you. While there are many video tutorials out there, this playlist has great production quality and is very extensive. While you need to actually code in order to learn, even just watching this playlist is a great supplement to whatever other resources you are using. ", 
        LocalDateTime.now()));


    String message_as_json = new Gson().toJson(resourceList);
    response.setContentType("application/json;");
    response.getWriter().println(message_as_json);
  }
}
