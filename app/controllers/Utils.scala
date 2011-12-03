package controllers

/**
 * Created by IntelliJ IDEA.
 * User: croiseaux
 * Date: 03/12/11
 * Time: 19:38
 * To change this template use File | Settings | File Templates.
 */

object Utils {
  def rpl = List("", "", "", "Foo", "", "Bar", "", "Qix", "", "", "")

  /*
  * norm retourne la chaine s si i est egal a 0, retourne une chaine vide sinon
  */
  def norm(s: String, i: Int): String = s * (1 / (1 + i.abs))

  def convert(i: Int): String = {
    var s = ""
    (1 to 9) map {
      nb =>
        s += norm(rpl(nb), i % nb) // i est divible par n
    }
    (math.log10(i).toInt to 0 by -1) map {
      exp =>
        (1 to 9) map {
          nb =>
            s += norm(rpl(nb), ((i / ((math.pow(10, exp)).toInt)) - nb) % 10) // i contient nb en exp ème position
        }
    }
    norm(i.toString(), s.size) + s // si s.size = 0 on retourne i, s sinon
  }

}