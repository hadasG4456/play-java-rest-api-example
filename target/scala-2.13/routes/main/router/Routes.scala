// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:1
  HomeController_0: controllers.HomeController,
  // @LINE:5
  PeopleController_1: controllers.PeopleController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:1
    HomeController_0: controllers.HomeController,
    // @LINE:5
    PeopleController_1: controllers.PeopleController
  ) = this(errorHandler, HomeController_0, PeopleController_1, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, PeopleController_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """hello""", """controllers.HomeController.hello"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/people""", """controllers.PeopleController.allPeople"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/people/""" + "$" + """id<[^/]+>""", """controllers.PeopleController.getPerson(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/people""", """controllers.PeopleController.createPerson(request:Request)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/people/""" + "$" + """id<[^/]+>""", """controllers.PeopleController.patchPerson(id:String, request:Request)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/people/""" + "$" + """id<[^/]+>""", """controllers.PeopleController.deletePerson(id:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:1
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_0.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """""",
      Seq()
    )
  )

  // @LINE:3
  private[this] lazy val controllers_HomeController_hello1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("hello")))
  )
  private[this] lazy val controllers_HomeController_hello1_invoker = createInvoker(
    HomeController_0.hello,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "hello",
      Nil,
      "GET",
      this.prefix + """hello""",
      """""",
      Seq()
    )
  )

  // @LINE:5
  private[this] lazy val controllers_PeopleController_allPeople2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/people")))
  )
  private[this] lazy val controllers_PeopleController_allPeople2_invoker = createInvoker(
    PeopleController_1.allPeople,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PeopleController",
      "allPeople",
      Nil,
      "GET",
      this.prefix + """api/people""",
      """""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_PeopleController_getPerson3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/people/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PeopleController_getPerson3_invoker = createInvoker(
    PeopleController_1.getPerson(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PeopleController",
      "getPerson",
      Seq(classOf[String]),
      "GET",
      this.prefix + """api/people/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_PeopleController_createPerson4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/people")))
  )
  private[this] lazy val controllers_PeopleController_createPerson4_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      PeopleController_1.createPerson(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PeopleController",
      "createPerson",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """api/people""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:12
  private[this] lazy val controllers_PeopleController_patchPerson5_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/people/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PeopleController_patchPerson5_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      PeopleController_1.patchPerson(fakeValue[String], fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PeopleController",
      "patchPerson",
      Seq(classOf[String], classOf[play.mvc.Http.Request]),
      "PATCH",
      this.prefix + """api/people/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_PeopleController_deletePerson6_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/people/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PeopleController_deletePerson6_invoker = createInvoker(
    PeopleController_1.deletePerson(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PeopleController",
      "deletePerson",
      Seq(classOf[String]),
      "DELETE",
      this.prefix + """api/people/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:1
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_0.index)
      }
  
    // @LINE:3
    case controllers_HomeController_hello1_route(params@_) =>
      call { 
        controllers_HomeController_hello1_invoker.call(HomeController_0.hello)
      }
  
    // @LINE:5
    case controllers_PeopleController_allPeople2_route(params@_) =>
      call { 
        controllers_PeopleController_allPeople2_invoker.call(PeopleController_1.allPeople)
      }
  
    // @LINE:7
    case controllers_PeopleController_getPerson3_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_PeopleController_getPerson3_invoker.call(PeopleController_1.getPerson(id))
      }
  
    // @LINE:10
    case controllers_PeopleController_createPerson4_route(params@_) =>
      call { 
        controllers_PeopleController_createPerson4_invoker.call(
          req => PeopleController_1.createPerson(req))
      }
  
    // @LINE:12
    case controllers_PeopleController_patchPerson5_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_PeopleController_patchPerson5_invoker.call(
          req => PeopleController_1.patchPerson(id, req))
      }
  
    // @LINE:14
    case controllers_PeopleController_deletePerson6_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_PeopleController_deletePerson6_invoker.call(PeopleController_1.deletePerson(id))
      }
  }
}
