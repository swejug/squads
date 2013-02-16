package se.swejug.squads.servlets;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public abstract class AbstractServlet extends HttpServlet {

   private static final long serialVersionUID = 1L;

   private static final Logger LOG = Logger.getLogger(AbstractServlet.class);

   public List<String> getParts(HttpServletRequest request) {
      String servletPath = request.getServletPath();
      List<String> parts = new ArrayList<String>();
      for (String part : servletPath.split("/")) {
         String trimed = part.trim();
         if (!trimed.isEmpty()) {
            parts.add(trimed);
         }
      }
      LOG.info("Transformed servlet path=" + servletPath + " to parts=" + parts.toString());
      return parts;
   }
}
