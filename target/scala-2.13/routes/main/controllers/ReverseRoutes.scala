// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:2
package controllers {

  // @LINE:2
  class ReversePeopleController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:2
    def allPeople: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/people/")
    }
  
    // @LINE:11
    def deletePerson(id:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "api/people/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:9
    def patchPerson(id:String): Call = {
      
      Call("PATCH", _prefix + { _defaultPrefix } + "api/people/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:4
    def getPerson(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/people/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:7
    def createPerson(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/people/")
    }
  
  }

  // @LINE:15
  class ReverseTasksController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:23
    def deleteTask(id:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "api/tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:15
    def allTasks(id:String, status:String = null): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/people/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/tasks/" + play.core.routing.queryString(List(if(status == null) None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("status", status)))))
    }
  
    // @LINE:21
    def patchTask(id:String): Call = {
      
      Call("PATCH", _prefix + { _defaultPrefix } + "api/tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:17
    def createTask(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/people/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/tasks/")
    }
  
    // @LINE:29
    def putStatus(id:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "api/tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/status")
    }
  
    // @LINE:25
    def getStatus(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/status")
    }
  
    // @LINE:31
    def putOwner(id:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "api/tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/owner")
    }
  
    // @LINE:19
    def getTask(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:27
    def getOwner(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/owner")
    }
  
  }


}
