package se.swejug.squads.servlets;

import java.util.ArrayList;
import java.util.List;

public class Link {

   private final List<String> parts = new ArrayList<String>();

   private String label;

   private final String contextPath;

   public Link(String contextPath) {
      this.contextPath = contextPath;
   }

   public String getLabel() {
      return label;
   }

   public void setLabel(String label) {
      this.label = label;
   }

   public List<String> getParts() {
      return parts;
   }

   public String getUrl() {
      StringBuilder sb = new StringBuilder();
      sb.append(contextPath);
      for (String part : parts) {
         sb.append("/").append(part);
      }
      return sb.toString();
   }
}
