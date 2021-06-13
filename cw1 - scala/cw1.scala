package cw1

import scala.annotation.tailrec

object cw1 extends App{

  //Zadanie 1
  val dni = List("Poniedzialek", "Wtorek", "Sroda", "Czwartek","Piatek","Sobota","Niedziela")

  //1a
  def dniFor(lista: List[String]): String ={
    var dniString = lista.head
    for (n <- lista.tail) dniString += ", " + n
    dniString
  }
  println("1a: " + dniFor(dni))

  //1b
  def dniNaPFor(lista: List[String]): String ={
    var dniString = ""
    for (n <- lista) {
      if(n.startsWith("P"))
        dniString += n + ", "
    }
    dniString
  }
  println("1b: " + dniNaPFor(dni))

  //1c
  def dniWhile(lista: List[String]): String ={
    var dniString = lista.head
    var tmp = lista.tail
    while(tmp.nonEmpty){
      dniString += ", " + tmp.head
      tmp = tmp.tail
    }
    dniString
  }
  println("1c: " + dniWhile(dni))

  //2a
  def rek(lista: List[String]): String ={

    lista.length match {
      case 0 => ""
      case 1 => lista.head
      case _ => lista.head + ", " + rek(lista.tail)
    }
  }
  println("2a: " + rek(dni))

  //2b
  def rekOdKonca(lista: List[String]): String ={

    lista.length match {
      case 0 => ""
      case 1 => lista.head
      case _ => rekOdKonca(lista.tail) + ", " + lista.head
    }
  }
  println("2b: " + rekOdKonca(dni))

  //3
  @tailrec
  def rekOgon(lista: List[String], string: String = ""): String ={
    val str = string + ", " + lista.head
    lista.length match {
      case 1 => str
      case _ => rekOgon(lista.tail, str)
    }
  }
  println("3: " + rekOgon(dni))

  //4a
  def foldl(lista: List[String]): String ={
    lista.foldLeft("")(_+ ", " +_)
  }
  println("4a: " + foldl(dni))

  //4b
  def foldr(lista: List[String]): String ={
    lista.foldRight("")(_+ ", " +_)
  }
  println("4b: " + foldr(dni))

  //4c
  def foldlNaP(lista: List[String]): String ={
    lista.foldLeft(""){(z, f) => if(f.startsWith("P")) z + ", " + f else z }
  }
  println("4c: " + foldlNaP(dni))

  //5
  val mapaCen = Map("turbo" -> 5000, "intercooler" -> 600, "dolot" -> 1000, "downpipe" -> 800)

  val deprecated = mapaCen.mapValues(_ * 5) // edytor pokazuje że "mapValues is deprecated"

  //Znalazłem dwa inne sposoby, działają tak samo
  val mapaCen10 = mapaCen map {case (key, value) => (key, value*0.9)}
  val mapaCen102 = mapaCen.transform((key, value) => value*0.9)

  println("5 przed: " + mapaCen)
  println("5 po: " + mapaCen10)

  //6
  def krot(krot: Tuple3[Int, String, Double]): Unit ={
    println("6: " + krot._1 + ", " + krot._2 + ", " + krot._3)
  }
  krot(Tuple3(2, "dwa", 2.2))

  //7
  val mapaOpcji: Map[String, Option[String]] = Map("Golf" -> Some("VW"), "A4" -> Some("Audi"), "Focus" -> Some("Ford"), "Leon" -> Some("Seat"))
  println("7a: " + mapaOpcji.getOrElse("Golf", "Brak"))
  println("7b: " + mapaOpcji.getOrElse("A3", "Brak"))

  //8
  val listaZer = List(5,6,0,5,8,0,0,3,1,0,5,15,0,45,0,25,36)

  def usunZera(lista: List[Int]): List[Int] = {
    if(!lista.isEmpty) {
      if(lista.head == 0){
        usunZera(lista.tail)
      }else{
        lista.head :: usunZera(lista.tail)
      }
    }else{
      Nil
    }
  }
  println("8a: " + listaZer)
  println("8b: " + usunZera(listaZer))

  //9
  def plus1(lista: List[Int]): List[Int] = {
    lista map (value => value + 1)
  }
  println("9: " + plus1(usunZera(listaZer))) //Na przykładzie listy bez zer z poprzedniego ćwiczenia

  //10
  val real = List(-5.1,6.8,-7.6,-2.4,5.6,-8.3,-1.4,5.6)
  def abs512(lista: List[Double]): List[Double] = {
    lista filter (_ > -5) filter (_ < 12) map (value => math.abs(value))
  }
  println("10a: " + real)
  println("10b: " + abs512(real))

}
