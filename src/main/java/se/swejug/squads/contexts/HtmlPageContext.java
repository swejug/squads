package se.swejug.squads.contexts;

import java.util.List;

import se.swejug.squads.servlets.Link;

public abstract class HtmlPageContext extends HtmlContext {

   private String pageAuthor;

   private String pageDescription;

   private Link link;

   private List<Link> path;

   public String getPageAuthor() {
      return pageAuthor;
   }

   public void setPageAuthor(String pageAuthor) {
      this.pageAuthor = pageAuthor;
   }

   public String getPageDescription() {
      return pageDescription;
   }

   public void setPageDescription(String pageDescription) {
      this.pageDescription = pageDescription;
   }

   public Link getLink() {
      return link;
   }

   public void setLink(Link link) {
      this.link = link;
   }

   public List<Link> getPath() {
      return path;
   }

   public void setPath(List<Link> path) {
      this.path = path;
   }

}
