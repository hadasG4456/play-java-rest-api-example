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
  // @LINE:3
  HomeController_0: controllers.HomeController,
  // @LINE:7
  PeopleController_1: controllers.PeopleController,
  // @LINE:20
  TasksController_2: controllers.TasksController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:3
    HomeController_0: controllers.HomeController,
    // @LINE:7
    PeopleController_1: controllers.PeopleController,
    // @LINE:20
    TasksController_2: controllers.TasksController
  ) = this(errorHandler, HomeController_0, PeopleController_1, TasksController_2, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, PeopleController_1, TasksController_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """hello""", """controllers.HomeController.hello"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/people/""", """controllers.PeopleController.allPeople"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/people/""" + "$" + """id<[^/]+>""", """controllers.PeopleController.getPerson(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/people/""", """controllers.PeopleController.createPerson(request:Request)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/people/""" + "$" + """id<[^/]+>""", """controllers.PeopleController.patchPerson(id:String, request:Request)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/people/""" + "$" + """id<[^/]+>""", """controllers.PeopleController.deletePerson(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/people/""" + "$" + """id<[^/]+>/tasks""", """controllers.TasksController.allTasks(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/people/""" + "$" + """id<[^/]+>/tasks""", """controllers.TasksController.createTask(id:String, request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/tasks/""" + "$" + """id<[^/]+>""", """controllers.TasksController.getTask(id:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:3
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

  // @LINE:5
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

  // @LINE:7
  private[this] lazy val controllers_PeopleController_allPeople2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/people/")))
  )
  private[this] lazy val controllers_PeopleController_allPeople2_invoker = createInvoker(
    PeopleController_1.allPeople,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PeopleController",
      "allPeople",
      Nil,
      "GET",
      this.prefix + """api/people/""",
      """""",
      Seq()
    )
  )

  // @LINE:9
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

  // @LINE:12
  private[this] lazy val controllers_PeopleController_createPerson4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/people/")))
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
      this.prefix + """api/people/""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:14
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

  // @LINE:16
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

  // @LINE:20
  private[this] lazy val controllers_TasksController_allTasks7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/people/"), DynamicPart("id", """[^/]+""",true), StaticPart("/tasks")))
  )
  private[this] lazy val controllers_TasksController_allTasks7_invoker = createInvoker(
    TasksController_2.allTasks(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TasksController",
      "allTasks",
      Seq(classOf[String]),
      "GET",
      this.prefix + """api/people/""" + "$" + """id<[^/]+>/tasks""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_TasksController_createTask8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/people/"), DynamicPart("id", """[^/]+""",true), StaticPart("/tasks")))
  )
  private[this] lazy val controllers_TasksController_createTask8_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      TasksController_2.createTask(fakeValue[String], fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TasksController",
      "createTask",
      Seq(classOf[String], classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """api/people/""" + "$" + """id<[^/]+>/tasks""",
      """""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_TasksController_getTask9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/tasks/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TasksController_getTask9_invoker = createInvoker(
    TasksController_2.getTask(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TasksController",
      "getTask",
      Seq(classOf[String]),
      "GET",
      this.prefix + """api/tasks/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:3
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_0.index)
      }
  
    // @LINE:5
    case controllers_HomeController_hello1_route(params@_) =>
      call { 
        controllers_HomeController_hello1_invoker.call(HomeController_0.hello)
      }
  
    // @LINE:7
    case controllers_PeopleController_allPeople2_route(params@_) =>
      call { 
        controllers_PeopleController_allPeople2_invoker.call(PeopleController_1.allPeople)
      }
  
    // @LINE:9
    case controllers_PeopleController_getPerson3_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_PeopleController_getPerson3_invoker.call(PeopleController_1.getPerson(id))
      }
  
    // @LINE:12
    case controllers_PeopleController_createPerson4_route(params@_) =>
      call { 
        controllers_PeopleController_createPerson4_invoker.call(
          req => PeopleController_1.createPerson(req))
      }
  
    // @LINE:14
    case controllers_PeopleController_patchPerson5_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_PeopleController_patchPerson5_invoker.call(
          req => PeopleController_1.patchPerson(id, req))
      }
  
    // @LINE:16
    case controllers_PeopleController_deletePerson6_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_PeopleController_deletePerson6_invoker.call(PeopleController_1.deletePerson(id))
      }
  
    // @LINE:20
    case controllers_TasksController_allTasks7_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_TasksController_allTasks7_invoker.call(TasksController_2.allTasks(id))
      }
  
    // @LINE:22
    case controllers_TasksController_createTask8_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_TasksController_createTask8_invoker.call(
          req => TasksController_2.createTask(id, req))
      }
  
    // @LINE:24
    case controllers_TasksController_getTask9_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_TasksController_getTask9_invoker.call(TasksController_2.getTask(id))
      }
  }
}
