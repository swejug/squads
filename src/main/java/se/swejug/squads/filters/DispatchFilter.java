package se.swejug.squads.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class DispatchFilter implements Filter {

   private static final Logger LOG = Logger.getLogger(DispatchFilter.class);

   public static final String REQUEST_PARTS = "swejug.request.parts";

   // TODO: get this from web.xml instead
   private static final String WEB_SERVLET = "/html-servlet";

   private String[] dirs = new String[] { "css", "js", "img" };

   private List<String> staticFiles = new ArrayList<String>();

   public void init(FilterConfig config) throws ServletException {
      LOG.trace("init...");
      ServletContext context = config.getServletContext();

      // stack static file directories
      Stack<String> stack = new Stack<String>();
      for (String dir : dirs) {
         stack.push("/" + dir + "/");
      }
      // traverse static file directories and save file paths
      while (!stack.isEmpty()) {
         String dir = stack.pop();
         @SuppressWarnings("unchecked")
         Set<String> paths = context.getResourcePaths(dir);
         for (String path : paths) {
            if (path.matches("(/[a-z]+)+/")) {
               stack.push(path);
            } else { // if (path.matches(".+\\.[a-z]+")) {
               staticFiles.add(path);
            }
         }
      }
      LOG.info("Static files=" + staticFiles.toString());
   }

   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

      HttpServletRequest httpRequest = (HttpServletRequest) request;
      LOG.info("Filtering request=" + httpRequest.getRequestURL().toString());
      LOG.trace(request.toString());

      // this is the focus part of the path.
      // i.e. http://swejug.se/swejug-united/foo/bar -> /foo/bar
      String servletPath = httpRequest.getServletPath();

      // filter static files or forward
      if (staticFiles.contains(servletPath)) {
         chain.doFilter(request, response);
      } else {
         // TODO: select html or rest servlet based on accept type
         request.getRequestDispatcher(WEB_SERVLET).forward(request, response);
      }
   }

   public void destroy() {
      LOG.trace("destroy...");
   }

}
