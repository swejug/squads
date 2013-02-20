package se.swejug.squads.builders;

import java.util.List;

import se.swejug.squads.beans.Home;
import se.swejug.squads.beans.Link;
import se.swejug.squads.repository.Repository;

public abstract class AbstractBuilder {

   private Repository repository;
   private LinkBuilder linkBuilder;

   public AbstractBuilder(String contextPath) {
      repository = new Repository(contextPath);
      linkBuilder = new LinkBuilder(contextPath);
   }

   protected List<Home> getHomes() {
      return repository.getHomes();
   }

   protected Link build(String title, List<String> parts) {
      return linkBuilder.build(title, parts);
   }
}
