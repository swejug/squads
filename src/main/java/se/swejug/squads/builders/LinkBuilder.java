package se.swejug.squads.builders;

import java.util.List;

import se.swejug.squads.servlets.Link;

public class LinkBuilder {

   private final String contextPath;

   public LinkBuilder(String contextPath) {
      this.contextPath = contextPath;
   }

   public Link build(String title, List<String> parts) {
      return makeLink(title, parts);
   }

   private Link makeLink(String title, List<String> parts) {
      Link link = new Link(contextPath);
      link.setLabel(title);
      link.getParts().addAll(parts);
      return link;
   }
}
