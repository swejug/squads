package se.swejug.squads.builders;

import java.util.List;

import se.swejug.squads.beans.Content;
import se.swejug.squads.beans.Group;
import se.swejug.squads.beans.Home;
import se.swejug.squads.beans.Member;
import se.swejug.squads.contexts.HtmlContext;
import se.swejug.squads.repository.Repository;

public class HtmlBuilder {

   public HtmlContext build(String contextPath, List<String> parts) {
      Repository repository = new Repository(contextPath);
      Content content = repository.lookup(parts);
      HtmlContext context = null;
      if (content instanceof Home) {
         Home home = (Home) content;
         HtmlHomeBuilder builder = new HtmlHomeBuilder(contextPath);
         context = builder.build(home);
      } else if (content instanceof Group) {
         Group group = (Group) content;
         HtmlGroupBuilder builder = new HtmlGroupBuilder(contextPath);
         context = builder.build(group);
      } else if (content instanceof Member) {
         Member member = (Member) content;
         HtmlMemberBuilder builder = new HtmlMemberBuilder(contextPath);
         context = builder.build(member);
      }
      return context;
   }

}
