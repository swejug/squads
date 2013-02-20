package se.swejug.squads.builders;

import java.util.ArrayList;
import java.util.Collections;

import se.swejug.squads.beans.Home;
import se.swejug.squads.beans.Link;
import se.swejug.squads.beans.Member;
import se.swejug.squads.contexts.HtmlContext;
import se.swejug.squads.contexts.HtmlHomeContext;

public class HtmlMemberBuilder extends AbstractBuilder{

   public HtmlMemberBuilder(String contextPath) {
      super(contextPath);
   }

   public HtmlContext build(Member member) {

      HtmlHomeContext context = new HtmlHomeContext();
      context.setPageAuthor(member.getLink().getLabel());
      context.setPageDescription("Yes, SweJUG Rules a lot...");

      ArrayList<Link> menu = new ArrayList<Link>();
      for (Home home2 : getHomes()) {
         menu.add(home2.getLink());
      }
      context.setMenu(menu);

      Link home = build("Home", Collections.<String>emptyList());
      context.setPath(Collections.<Link>singletonList(home));
      context.setLink(member.getLink());
      return context;
   }


}
