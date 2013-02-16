package se.swejug.squads.servlets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HtmlContext {

   public final static String CONTEXT_ATTRIBUTE = "context";

   public final static String PAGE_AUTHOR = "pageAuthor";

   public final static String PAGE_TITLE = "pageTitle";

   public final static String PAGE_DESCRIPTION = "pageDescription";

   private final List<Link> crumbs = new ArrayList<Link>();

   private Link link;

   private final Map<String, String> values = new HashMap<String, String>();

   public List<Link> getCrumbs() {
      return crumbs;
   }

   public void setLink(Link link) {
      this.link = link;
   }

   public Link getLink() {
      return link;
   }

   public Map<String, String> getValues() {
      return values;
   }

   public String getPageAuthor() {
      return values.get(PAGE_AUTHOR);
   }

   public String getPageTitle() {
      return values.get(PAGE_TITLE);
   }

   public String getPageDescription() {
      return values.get(PAGE_DESCRIPTION);
   }
}
