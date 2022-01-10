// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReversePeopleController PeopleController = new controllers.ReversePeopleController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReversePeopleController PeopleController = new controllers.javascript.ReversePeopleController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
  }

}