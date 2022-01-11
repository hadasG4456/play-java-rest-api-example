// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:1
package controllers.javascript {

  // @LINE:1
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:1
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:3
    def hello: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.hello",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "hello"})
        }
      """
    )
  
  }

  // @LINE:5
  class ReversePeopleController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:5
    def allPeople: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PeopleController.allPeople",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/people"})
        }
      """
    )
  
    // @LINE:14
    def deletePerson: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PeopleController.deletePerson",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "api/people/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:12
    def patchPerson: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PeopleController.patchPerson",
      """
        function(id0) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "api/people/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:7
    def getPerson: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PeopleController.getPerson",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/people/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:10
    def createPerson: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PeopleController.createPerson",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/people"})
        }
      """
    )
  
  }


}
