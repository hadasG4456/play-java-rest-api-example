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
  // @LINE:2
  PeopleController_0: controllers.PeopleController,
  // @LINE:15
  TasksController_1: controllers.TasksController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:2
    PeopleController_0: controllers.PeopleController,
    // @LINE:15
    TasksController_1: controllers.TasksController
  ) = this(errorHandler, PeopleController_0, TasksController_1, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, PeopleController_0, TasksController_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
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


  // @LINE:2
  private[this] lazy val controllers_PeopleController_allPeople0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/people/")))
  )
  private[this] lazy val controllers_PeopleController_allPeople0_invoker = createInvoker(
    PeopleController_0.allPeople,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PeopleController",
      "allPeople",
      Nil,
      "GET",
      this.prefix + """api/people/""",
      """ People:""",
      Seq()
    )
  )

  // @LINE:4
  private[this] lazy val controllers_PeopleController_getPerson1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/people/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PeopleController_getPerson1_invoker = createInvoker(
    PeopleController_0.getPerson(fakeValue[String]),
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

  // @LINE:7
  private[this] lazy val controllers_PeopleController_createPerson2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/people/")))
  )
  private[this] lazy val controllers_PeopleController_createPerson2_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      PeopleController_0.createPerson(fakeValue[play.mvc.Http.Request]),
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

  // @LINE:9
  private[this] lazy val controllers_PeopleController_patchPerson3_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/people/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PeopleController_patchPerson3_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      PeopleController_0.patchPerson(fakeValue[String], fakeValue[play.mvc.Http.Request]),
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

  // @LINE:11
  private[this] lazy val controllers_PeopleController_deletePerson4_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/people/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PeopleController_deletePerson4_invoker = createInvoker(
    PeopleController_0.deletePerson(fakeValue[String]),
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

  // @LINE:15
  private[this] lazy val controllers_TasksController_allTasks5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/people/"), DynamicPart("id", """[^/]+""",true), StaticPart("/tasks/")))
  )
  private[this] lazy val controllers_TasksController_allTasks5_invoker = createInvoker(
    TasksController_1.allTasks(fakeValue[String], fakeValue[String]),
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

  // @LINE:17
  private[this] lazy val controllers_TasksController_createTask6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/people/"), DynamicPart("id", """[^/]+""",true), StaticPart("/tasks/")))
  )
  private[this] lazy val controllers_TasksController_createTask6_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      TasksController_1.createTask(fakeValue[String], fakeValue[play.mvc.Http.Request]),
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

  // @LINE:19
  private[this] lazy val controllers_TasksController_getTask7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/tasks/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TasksController_getTask7_invoker = createInvoker(
    TasksController_1.getTask(fakeValue[String]),
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

  // @LINE:21
  private[this] lazy val controllers_TasksController_patchTask8_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/tasks/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TasksController_patchTask8_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      TasksController_1.patchTask(fakeValue[String], fakeValue[play.mvc.Http.Request]),
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

  // @LINE:23
  private[this] lazy val controllers_TasksController_deleteTask9_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/tasks/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TasksController_deleteTask9_invoker = createInvoker(
    TasksController_1.deleteTask(fakeValue[String]),
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

  // @LINE:25
  private[this] lazy val controllers_TasksController_getStatus10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/tasks/"), DynamicPart("id", """[^/]+""",true), StaticPart("/status")))
  )
  private[this] lazy val controllers_TasksController_getStatus10_invoker = createInvoker(
    TasksController_1.getStatus(fakeValue[String]),
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

  // @LINE:27
  private[this] lazy val controllers_TasksController_getOwner11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/tasks/"), DynamicPart("id", """[^/]+""",true), StaticPart("/owner")))
  )
  private[this] lazy val controllers_TasksController_getOwner11_invoker = createInvoker(
    TasksController_1.getOwner(fakeValue[String]),
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

  // @LINE:29
  private[this] lazy val controllers_TasksController_putStatus12_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/tasks/"), DynamicPart("id", """[^/]+""",true), StaticPart("/status")))
  )
  private[this] lazy val controllers_TasksController_putStatus12_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      TasksController_1.putStatus(fakeValue[String], fakeValue[play.mvc.Http.Request]),
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

  // @LINE:31
  private[this] lazy val controllers_TasksController_putOwner13_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/tasks/"), DynamicPart("id", """[^/]+""",true), StaticPart("/owner")))
  )
  private[this] lazy val controllers_TasksController_putOwner13_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      TasksController_1.putOwner(fakeValue[String], fakeValue[play.mvc.Http.Request]),
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
  
    // @LINE:2
    case controllers_PeopleController_allPeople0_route(params@_) =>
      call { 
        controllers_PeopleController_allPeople0_invoker.call(PeopleController_0.allPeople)
      }
  
    // @LINE:4
    case controllers_PeopleController_getPerson1_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_PeopleController_getPerson1_invoker.call(PeopleController_0.getPerson(id))
      }
  
    // @LINE:7
    case controllers_PeopleController_createPerson2_route(params@_) =>
      call { 
        controllers_PeopleController_createPerson2_invoker.call(
          req => PeopleController_0.createPerson(req))
      }
  
    // @LINE:9
    case controllers_PeopleController_patchPerson3_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_PeopleController_patchPerson3_invoker.call(
          req => PeopleController_0.patchPerson(id, req))
      }
  
    // @LINE:11
    case controllers_PeopleController_deletePerson4_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_PeopleController_deletePerson4_invoker.call(PeopleController_0.deletePerson(id))
      }
  
    // @LINE:15
    case controllers_TasksController_allTasks5_route(params@_) =>
      call(params.fromPath[String]("id", None), params.fromQuery[String]("status", Some(null))) { (id, status) =>
        controllers_TasksController_allTasks5_invoker.call(TasksController_1.allTasks(id, status))
      }
  
    // @LINE:17
    case controllers_TasksController_createTask6_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_TasksController_createTask6_invoker.call(
          req => TasksController_1.createTask(id, req))
      }
  
    // @LINE:19
    case controllers_TasksController_getTask7_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_TasksController_getTask7_invoker.call(TasksController_1.getTask(id))
      }
  
    // @LINE:21
    case controllers_TasksController_patchTask8_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_TasksController_patchTask8_invoker.call(
          req => TasksController_1.patchTask(id, req))
      }
  
    // @LINE:23
    case controllers_TasksController_deleteTask9_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_TasksController_deleteTask9_invoker.call(TasksController_1.deleteTask(id))
      }
  
    // @LINE:25
    case controllers_TasksController_getStatus10_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_TasksController_getStatus10_invoker.call(TasksController_1.getStatus(id))
      }
  
    // @LINE:27
    case controllers_TasksController_getOwner11_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_TasksController_getOwner11_invoker.call(TasksController_1.getOwner(id))
      }
  
    // @LINE:29
    case controllers_TasksController_putStatus12_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_TasksController_putStatus12_invoker.call(
          req => TasksController_1.putStatus(id, req))
      }
  
    // @LINE:31
    case controllers_TasksController_putOwner13_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_TasksController_putOwner13_invoker.call(
          req => TasksController_1.putOwner(id, req))
      }
  }
}
