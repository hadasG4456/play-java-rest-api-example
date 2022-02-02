// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:2
package controllers.javascript {

  // @LINE:2
  class ReversePeopleController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:2
    def allPeople: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PeopleController.allPeople",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/people/"})
        }
      """
    )
  
    // @LINE:11
    def deletePerson: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PeopleController.deletePerson",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "api/people/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:9
    def patchPerson: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PeopleController.patchPerson",
      """
        function(id0) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "api/people/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:4
    def getPerson: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PeopleController.getPerson",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/people/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:7
    def createPerson: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PeopleController.createPerson",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/people/"})
        }
      """
    )
  
  }

  // @LINE:15
  class ReverseTasksController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:23
    def deleteTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TasksController.deleteTask",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "api/tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:15
    def allTasks: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TasksController.allTasks",
      """
        function(id0,status1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/people/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0)) + "/tasks/" + _qS([(status1 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("status", status1))])})
        }
      """
    )
  
    // @LINE:21
    def patchTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TasksController.patchTask",
      """
        function(id0) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "api/tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:17
    def createTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TasksController.createTask",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/people/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0)) + "/tasks/"})
        }
      """
    )
  
    // @LINE:29
    def putStatus: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TasksController.putStatus",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "api/tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0)) + "/status"})
        }
      """
    )
  
    // @LINE:25
    def getStatus: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TasksController.getStatus",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0)) + "/status"})
        }
      """
    )
  
    // @LINE:31
    def putOwner: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TasksController.putOwner",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "api/tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0)) + "/owner"})
        }
      """
    )
  
    // @LINE:19
    def getTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TasksController.getTask",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:27
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
