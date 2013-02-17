package se.swejug.squads.builders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import se.swejug.squads.contexts.HtmlContext;
import se.swejug.squads.contexts.HtmlHomeContext;
import se.swejug.squads.contexts.HtmlPageContext;
import se.swejug.squads.servlets.Link;

public class HtmlContextBuilder {

   public HtmlContext build(String contextPath, List<String> parts) {
      HtmlPageContext context = new HtmlHomeContext();
      context.setPageAuthor("Thobias Bergqvist");
      context.setPageDescription("Yes, SweJUG Rules a lot...");
      LinkBuilder builder = new LinkBuilder(contextPath);
      List<Link> path = new ArrayList<Link>();
      Link home = builder.build("Home", Collections.<String>emptyList());
      if (parts.isEmpty()) {
         context.setLink(home);
      } else {
         path.add(home);
         for (int i = 0; i < parts.size()-1; i++) {
            path.add(builder.build(parts.get(i), parts.subList(0, i+1)));
         }
         context.setLink(builder.build(parts.get(parts.size()-1), parts));
      }
      context.setPath(path);
      return context;
   }

}
