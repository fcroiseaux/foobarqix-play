package controllers

object Utils {

  /*
  * norm retourne la chaine s si i est egal a 0, retourne une chaine vide sinon
  */
  def norm(s: String, i: Int): String = s * (1 / (1 + i.abs))

  def convertGen(i: Int, rp1: String = "", rp2: String = "", rp3: String = "", rp4: String = "", rp5: String = "", rp6: String = "", rp7: String = "", rp8: String = "", rp9: String = ""): String = {

    var s = ""
    var rpl = List("", rp1, rp2, rp3, rp4, rp5, rp6, rp7, rp8, rp9)
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
  
  val convert = convertGen(_:Int, "", "", "Foo", "", "Bar", "", "Qix", "", "")

}