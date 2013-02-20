package se.swejug.squads.repository;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import se.swejug.squads.beans.Content;
import se.swejug.squads.beans.Group;
import se.swejug.squads.beans.Home;
import se.swejug.squads.beans.Member;
import se.swejug.squads.builders.LinkBuilder;

public class Repository {

   private static final Logger LOG = Logger.getLogger(Repository.class);

   private List<Member> members = new ArrayList<Member>();
   private List<Group> groups = new ArrayList<Group>();
   private List<Home> homes = new ArrayList<Home>();

   private LinkBuilder builder;

   public Repository(String contextPath) {
      builder = new LinkBuilder(contextPath);
      String[] names = new String[]{"Alan", "Bill"};
      String[] towns = new String[]{"Göteborg", "Linköping", "Malmö", "Norrköping", "Stockholm"};
      String[] pages = new String[]{"Groups", "Members", "Projects"};
      for (String name1 : names) {
         for (String name2 : names) {
            Member member = new Member();
            String name = name1 + " " + name2 + "sson";
            member.setLink(builder.build(name, Collections.singletonList(makeKey(name))));
            members.add(member);
            LOG.trace("member=" + member.getLink().getUrl());
         }
      }
      for (String town : towns) {
         Group group = new Group();
         group.setLink(builder.build(town, Collections.singletonList(makeKey(town))));
         groups.add(group);
         LOG.trace("group=" + group.getLink().getUrl());
      }
      Home home = new Home();
      home.setLink(builder.build("Home", Collections.<String>emptyList()));
      homes.add(home);
      LOG.info("home=" + home.getLink().getUrl());
      for (String page : pages) {
         home = new Home();
         home.setLink(builder.build(page, Collections.singletonList(makeKey(page))));
         homes.add(home);
         LOG.trace("home=" + home.getLink().getUrl());
      }
   }

   private String makeKey(String seed) {
      String key = seed.replaceAll(" ", "-");
      key = Normalizer.normalize(key, Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+","");
      return key.toLowerCase();
   }

   public Content lookup(List<String> parts) {
      Content content = null;
      if (parts.isEmpty()) {
         return homes.get(0);
      } else if (parts.size()==1) {
         for (Home home : homes) {
            if (home.getLink().matches(parts)) {
               return home;
            }
         }
         for (Member member : members) {
            if (member.getLink().matches(parts)) {
               return member;
            }
         }
         for (Group group : groups) {
            if (group.getLink().matches(parts)) {
               return group;
            }
         }
      }
      return content;
   }

   public List<Home> getHomes() {
      return homes;
   }
}
