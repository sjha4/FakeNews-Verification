
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/samir/Desktop/3rd sem/Social Computing/termproject/play/social/conf/routes
// @DATE:Sun Dec 03 01:09:49 EST 2017

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def predict(message:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "predict/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("message", message)))
    }
  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:9
    def evaluate(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "evaluate")
    }
  
    // @LINE:8
    def train(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "train")
    }
  
  }

  // @LINE:13
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
