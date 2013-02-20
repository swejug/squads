package se.swejug.squads.builders;

import java.util.ArrayList;
import java.util.Collections;

import se.swejug.squads.beans.Home;
import se.swejug.squads.beans.Link;
import se.swejug.squads.contexts.HtmlContext;
import se.swejug.squads.contexts.HtmlHomeContext;
import se.swejug.squads.contexts.HtmlPageContext;

public class HtmlHomeBuilder extends AbstractBuilder{

   public HtmlHomeBuilder(String contextPath) {
      super(contextPath);
   }

   public HtmlContext build(Home home) {

      HtmlPageContext context = new HtmlHomeContext();
      context.setPageAuthor("Thobias Bergqvist");
      context.setPageDescription("Yes, SweJUG Rules a lot...");

      ArrayList<Link> menu = new ArrayList<Link>();
      for (Home home2 : getHomes()) {
         menu.add(home2.getLink());
      }
      context.setMenu(menu);

      context.setPath(Collections.<Link>emptyList());
      context.setLink(home.getLink());
      return context;
   }


}
