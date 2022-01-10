// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:1
package controllers {

  // @LINE:1
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:1
    def index: Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:3
    def hello: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "hello")
    }
  
  }

  // @LINE:5
  class ReversePeopleController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def allPeople: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/people")
    }
  
    // @LINE:9
    def getPerson(id:java.util.UUID): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/people/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[java.util.UUID]].unbind("id", id)))
    }
  
    // @LINE:14
    def patchPerson(id:java.util.UUID): Call = {
      
      Call("PATCH", _prefix + { _defaultPrefix } + "api/people/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[java.util.UUID]].unbind("id", id)))
    }
  
    // @LINE:16
    def deletePerson(id:java.util.UUID): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "api/people/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[java.util.UUID]].unbind("id", id)))
    }
  
    // @LINE:5
    def index: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api")
    }
  
    // @LINE:12
    def createPerson(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/people")
    }
  
  }


}
