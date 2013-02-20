package se.swejug.squads.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import se.swejug.squads.builders.HtmlBuilder;
import se.swejug.squads.contexts.HtmlContext;
import se.swejug.squads.filters.DispatchFilter;

public class HtmlServlet extends HttpServlet {

   private static final long serialVersionUID = 1L;

   private static final Logger LOG = Logger.getLogger(HtmlServlet.class);

   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {

      LOG.info("do get...");
      @SuppressWarnings("unchecked")
      List<String> parts = (List<String>) request.getAttribute(DispatchFilter.REQUEST_PARTS);

      HtmlBuilder builder = new HtmlBuilder();
      String contextPath = request.getContextPath();
      HtmlContext context = builder.build(contextPath, parts);

      request.setAttribute(HtmlContext.ATTRIBUTE, context);
      request.getRequestDispatcher("jsp/" + context.getJspPage()).forward(request, response);
   }

}
