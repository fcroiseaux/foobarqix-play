package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import views._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index(paramForm))
  }

  /**
   * Formulaire de saisie des paramètres de foobarqix
   */
  val paramForm = Form(
    of(
        "nbIter" -> number,
        "rp1" -> optional(text),
        "rp2" -> optional(text),
        "rp3" -> optional(text)
      )
  )

  def computeReplacements = Action {
    implicit request =>
      paramForm.bindFromRequest.fold(
      formWithErrors => BadRequest(html.index(formWithErrors)), {
        case (nbIter, rp1, rp2, rp3) => Ok(html.result((1 to nbIter.toInt)))
      }
      )
  }

  def result(nbIter: String) = Action {  request =>
    Ok(html.basicresult((1 to  nbIter.toInt)))
  }
}