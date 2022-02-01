// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:3
package controllers {

  // @LINE:3
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:3
    def index: Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:5
    def hello: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "hello")
    }
  
  }

  // @LINE:7
  class ReversePeopleController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def allPeople: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/people")
    }
  
    // @LINE:16
    def deletePerson(id:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "api/people/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:14
    def patchPerson(id:String): Call = {
      
      Call("PATCH", _prefix + { _defaultPrefix } + "api/people/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:9
    def getPerson(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/people/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:12
    def createPerson(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/people")
    }
  
  }

  // @LINE:20
  class ReverseTasksController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:20
    def allTasks(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/people/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/tasks")
    }
  
    // @LINE:22
    def getTask(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
  }


}
