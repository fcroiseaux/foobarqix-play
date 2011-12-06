package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import views._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index())
  }

  def result(nbIter: String, rp1: String, rp2: String, rp3: String, rp4: String, rp5: String, rp6: String, rp7: String, rp8: String, rp9: String) = Action {  request =>
    Ok(html.basicresult((1 to  nbIter.toInt), Utils(List("", rp1, rp2, rp3, rp4, rp5, rp6, rp7, rp8, rp9))))
  }
}