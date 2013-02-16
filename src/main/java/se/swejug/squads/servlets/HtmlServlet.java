package se.swejug.squads.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HtmlServlet extends AbstractServlet {

   private static final long serialVersionUID = 1L;

   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      List<String> parts = getParts(request);
      // TODO: gather info and select appropriate jsp file

      HtmlContext ctx = new HtmlContext();
      ctx.set(HtmlContext.PAGE_AUTHOR, "Thobias Bergqvist");
      ctx.set(HtmlContext.PAGE_TITLE, "SweJUG Rules!");
      ctx.set(HtmlContext.PAGE_DESCRIPTION, "Yes, SweJUG Rules a lot...");
      request.setAttribute(HtmlContext.CONTEXT_ATTRIBUTE, ctx);
      request.getRequestDispatcher("jsp/home.jsp").forward(request, response);
   }

}
