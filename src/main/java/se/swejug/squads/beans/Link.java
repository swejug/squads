package se.swejug.squads.beans;

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

   public boolean matches(List<String> parts) {
      if (this.parts.size() != parts.size()) {
         return false;
      }
      int max = Math.min(this.parts.size(), parts.size());
      for (int i = 0; i < max; i++) {
         if (!this.parts.get(i).equals(parts.get(i))) {
            return false;
         }
      }
      return true;
   }
}
