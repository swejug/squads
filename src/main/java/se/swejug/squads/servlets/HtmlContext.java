package se.swejug.squads.servlets;

import java.util.HashMap;
import java.util.Map;

public class HtmlContext {

   public final static String CONTEXT_ATTRIBUTE = "context";

   public final static String PAGE_AUTHOR = "pageAuthor";

   public final static String PAGE_TITLE = "pageTitle";

   public final static String PAGE_DESCRIPTION = "pageDescription";

   private final Map<String, String> values = new HashMap<String, String>();

   public void set(String key, String value) {
      values.put(key, value);
   }

   public String get(String key) {
      return values.get(key);
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
