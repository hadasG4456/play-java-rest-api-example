// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:3
package controllers.javascript {

  // @LINE:3
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:3
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:5
    def hello: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.hello",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "hello"})
        }
      """
    )
  
  }

  // @LINE:7
  class ReversePeopleController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def allPeople: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PeopleController.allPeople",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/people/"})
        }
      """
    )
  
    // @LINE:16
    def deletePerson: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PeopleController.deletePerson",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "api/people/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:14
    def patchPerson: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PeopleController.patchPerson",
      """
        function(id0) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "api/people/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:9
    def getPerson: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PeopleController.getPerson",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/people/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:12
    def createPerson: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PeopleController.createPerson",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/people/"})
        }
      """
    )
  
  }

  // @LINE:20
  class ReverseTasksController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:28
    def deleteTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TasksController.deleteTask",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "api/tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:20
    def allTasks: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TasksController.allTasks",
      """
        function(id0,status1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/people/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0)) + "/tasks/" + _qS([(status1 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("status", status1))])})
        }
      """
    )
  
    // @LINE:26
    def patchTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TasksController.patchTask",
      """
        function(id0) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "api/tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:22
    def createTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TasksController.createTask",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/people/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0)) + "/tasks/"})
        }
      """
    )
  
    // @LINE:34
    def putStatus: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TasksController.putStatus",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "api/tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0)) + "/status"})
        }
      """
    )
  
    // @LINE:30
    def getStatus: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TasksController.getStatus",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0)) + "/status"})
        }
      """
    )
  
    // @LINE:36
    def putOwner: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TasksController.putOwner",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "api/tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0)) + "/owner"})
        }
      """
    )
  
    // @LINE:24
    def getTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TasksController.getTask",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:32
    def getOwner: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TasksController.getOwner",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0)) + "/owner"})
        }
      """
    )
  
  }


}
