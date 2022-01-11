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

  
    // @LINE:5
    def allPeople: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/people")
    }
  
    // @LINE:14
    def deletePerson(id:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "api/people/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:12
    def patchPerson(id:String): Call = {
      
      Call("PATCH", _prefix + { _defaultPrefix } + "api/people/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:7
    def getPerson(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/people/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:10
    def createPerson(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/people")
    }
  
  }


}
