package controllers

case class Utils(rpl: List[String]) {

  /*
  * norm retourne la chaine s si i est egal a 0, retourne une chaine vide sinon
  */
  def norm(s: String, i: Int): String = s * (1 / (1 + i.abs))

  def convertGen(i: Int): String = {

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