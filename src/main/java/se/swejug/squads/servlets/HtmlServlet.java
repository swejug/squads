package se.swejug.squads.servlets;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.swejug.squads.filters.DispatchFilter;

public class HtmlServlet extends AbstractServlet {

   private static final long serialVersionUID = 1L;

   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      @SuppressWarnings("unchecked")
      List<String> parts = (List<String>) request.getAttribute(DispatchFilter.REQUEST_PARTS);
      // TODO: gather info and select appropriate jsp file

      HtmlContext ctx = new HtmlContext();
      ctx.getValues().put(HtmlContext.PAGE_AUTHOR, "Thobias Bergqvist");
      ctx.getValues().put(HtmlContext.PAGE_TITLE, "SweJUG Rules!");
      ctx.getValues().put(HtmlContext.PAGE_DESCRIPTION, "Yes, SweJUG Rules a lot...");
      Link link = makeLink(request, "Home", Collections.<String>emptyList());
      ctx.getCrumbs().add(link);
      for (int i = 0; i < parts.size()-1; i++) {
         link = makeLink(request, parts.get(i), parts.subList(0, i+1));
         ctx.getCrumbs().add(link);
      }
      link = makeLink(request, parts.get(parts.size()-1), parts);
      ctx.setLink(link);
      request.setAttribute(HtmlContext.CONTEXT_ATTRIBUTE, ctx);
      request.getRequestDispatcher("jsp/home.jsp").forward(request, response);
   }

   private Link makeLink(HttpServletRequest request , String label, List<String> parts) {
      Link link = new Link(request.getContextPath());
      link.setLabel(label);
      link.getParts().addAll(parts);
      return link;
   }

}
