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
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/people/""" + "$" + """id<[^/]+>/tasks/""", """controllers.TasksController.allTasks(id:String, status:String ?= null)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/people/""" + "$" + """id<[^/]+>/tasks/""", """controllers.TasksController.createTask(id:String, request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/tasks/""" + "$" + """id<[^/]+>""", """controllers.TasksController.getTask(id:String)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/tasks/""" + "$" + """id<[^/]+>""", """controllers.TasksController.patchTask(id:String, request:Request)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/tasks/""" + "$" + """id<[^/]+>""", """controllers.TasksController.deleteTask(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/tasks/""" + "$" + """id<[^/]+>/status""", """controllers.TasksController.getStatus(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/tasks/""" + "$" + """id<[^/]+>/owner""", """controllers.TasksController.getOwner(id:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/tasks/""" + "$" + """id<[^/]+>/status""", """controllers.TasksController.putStatus(id:String, request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/tasks/""" + "$" + """id<[^/]+>/owner""", """controllers.TasksController.putOwner(id:String, request:Request)"""),
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
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/people/"), DynamicPart("id", """[^/]+""",true), StaticPart("/tasks/")))
  )
  private[this] lazy val controllers_TasksController_allTasks7_invoker = createInvoker(
    TasksController_2.allTasks(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TasksController",
      "allTasks",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """api/people/""" + "$" + """id<[^/]+>/tasks/""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_TasksController_createTask8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/people/"), DynamicPart("id", """[^/]+""",true), StaticPart("/tasks/")))
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
      this.prefix + """api/people/""" + "$" + """id<[^/]+>/tasks/""",
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

  // @LINE:26
  private[this] lazy val controllers_TasksController_patchTask10_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/tasks/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TasksController_patchTask10_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      TasksController_2.patchTask(fakeValue[String], fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TasksController",
      "patchTask",
      Seq(classOf[String], classOf[play.mvc.Http.Request]),
      "PATCH",
      this.prefix + """api/tasks/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:28
  private[this] lazy val controllers_TasksController_deleteTask11_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/tasks/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TasksController_deleteTask11_invoker = createInvoker(
    TasksController_2.deleteTask(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TasksController",
      "deleteTask",
      Seq(classOf[String]),
      "DELETE",
      this.prefix + """api/tasks/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:30
  private[this] lazy val controllers_TasksController_getStatus12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/tasks/"), DynamicPart("id", """[^/]+""",true), StaticPart("/status")))
  )
  private[this] lazy val controllers_TasksController_getStatus12_invoker = createInvoker(
    TasksController_2.getStatus(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TasksController",
      "getStatus",
      Seq(classOf[String]),
      "GET",
      this.prefix + """api/tasks/""" + "$" + """id<[^/]+>/status""",
      """""",
      Seq()
    )
  )

  // @LINE:32
  private[this] lazy val controllers_TasksController_getOwner13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/tasks/"), DynamicPart("id", """[^/]+""",true), StaticPart("/owner")))
  )
  private[this] lazy val controllers_TasksController_getOwner13_invoker = createInvoker(
    TasksController_2.getOwner(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TasksController",
      "getOwner",
      Seq(classOf[String]),
      "GET",
      this.prefix + """api/tasks/""" + "$" + """id<[^/]+>/owner""",
      """""",
      Seq()
    )
  )

  // @LINE:34
  private[this] lazy val controllers_TasksController_putStatus14_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/tasks/"), DynamicPart("id", """[^/]+""",true), StaticPart("/status")))
  )
  private[this] lazy val controllers_TasksController_putStatus14_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      TasksController_2.putStatus(fakeValue[String], fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TasksController",
      "putStatus",
      Seq(classOf[String], classOf[play.mvc.Http.Request]),
      "PUT",
      this.prefix + """api/tasks/""" + "$" + """id<[^/]+>/status""",
      """""",
      Seq()
    )
  )

  // @LINE:36
  private[this] lazy val controllers_TasksController_putOwner15_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/tasks/"), DynamicPart("id", """[^/]+""",true), StaticPart("/owner")))
  )
  private[this] lazy val controllers_TasksController_putOwner15_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      TasksController_2.putOwner(fakeValue[String], fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TasksController",
      "putOwner",
      Seq(classOf[String], classOf[play.mvc.Http.Request]),
      "PUT",
      this.prefix + """api/tasks/""" + "$" + """id<[^/]+>/owner""",
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
      call(params.fromPath[String]("id", None), params.fromQuery[String]("status", Some(null))) { (id, status) =>
        controllers_TasksController_allTasks7_invoker.call(TasksController_2.allTasks(id, status))
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
  
    // @LINE:26
    case controllers_TasksController_patchTask10_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_TasksController_patchTask10_invoker.call(
          req => TasksController_2.patchTask(id, req))
      }
  
    // @LINE:28
    case controllers_TasksController_deleteTask11_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_TasksController_deleteTask11_invoker.call(TasksController_2.deleteTask(id))
      }
  
    // @LINE:30
    case controllers_TasksController_getStatus12_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_TasksController_getStatus12_invoker.call(TasksController_2.getStatus(id))
      }
  
    // @LINE:32
    case controllers_TasksController_getOwner13_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_TasksController_getOwner13_invoker.call(TasksController_2.getOwner(id))
      }
  
    // @LINE:34
    case controllers_TasksController_putStatus14_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_TasksController_putStatus14_invoker.call(
          req => TasksController_2.putStatus(id, req))
      }
  
    // @LINE:36
    case controllers_TasksController_putOwner15_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_TasksController_putOwner15_invoker.call(
          req => TasksController_2.putOwner(id, req))
      }
  }
}
