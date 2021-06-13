package cw2

object cw2 extends App{

  val dni = List("Poniedzialek", "Wtorek", "Sroda", "Czwartek","Piatek","Sobota","Niedziela")

  //1
  def jakiDzien(dzien: String): String ={
    dzien match {
      case "Poniedzialek" | "Wtorek" | "Sroda" | "Czwartek" | "Piatek" => "Praca"
      case "Sobota" | "Niedziela" => "Weekend"
      case _ => "Nie ma takiego dnia"
    }
  }
  print("1: ")
  for (d <- dni) {
    print(jakiDzien(d) + ", ")
  }
  println(jakiDzien("Dzieńktóegoniema"))

  //2

  class KontoBankowe(private var _stanKonta: Double = 0){

    def this() = this(0)

    def stanKonta = _stanKonta

    def wplata(kwota: Double): Unit = {
      _stanKonta = _stanKonta + kwota
    }

    def wyplata(kwota: Double): Unit = {
      if(kwota <= _stanKonta) _stanKonta = _stanKonta - kwota
    }
  }

  var kb0 = new KontoBankowe
  var kb2 = new KontoBankowe(2)
  println("2: stan konta 0: " + kb0.stanKonta)
  println("2: stan konta 2: " + kb2.stanKonta)
  kb0.wplata(8)
  kb2.wplata(8)
  println("2: stan konta 0, po wpłacie 8: " + kb0.stanKonta)
  println("2: stan konta 2, po wpłacie 8: " + kb2.stanKonta)
  kb0.wyplata(3)
  kb2.wyplata(3)
  println("2: stan konta 0, po wypłacie 3: " + kb0.stanKonta)
  println("2: stan konta 2, po wypłacie 3: " + kb2.stanKonta)

  //3
  case class Osoba(val imie: String, val nazwisko: String)
  val o1 = new Osoba("Jan", "Kowalski")
  val o2 = new Osoba("Adam", "Nowak")
  val o3 = new Osoba("Kamil", "Ślimak") //Wiedział Pan że Kamil Ślimak od tyłu to Kamil Ślimak?
  val o4 = new Osoba("Ola", "Makota")

  def przywitanie(osoba: Osoba) = osoba match {
      case Osoba("Jan", "Kowalski") => "Witaj Jan"
      case Osoba("Adam", "Nowak") => "Miło Cię widzieć Adam"
      case Osoba("Kamil", "Ślimak") =>  "Kamil, to znowy Ty?"
      case Osoba(imie, nazwisko) => s"Dzień dobry $imie"
  }
  println("3a: " + przywitanie(o1))
  println("3a: " + przywitanie(o2))
  println("3a: " + przywitanie(o3))
  println("3a: " + przywitanie(o4))

  //4
  def trzykrotnie(calkowita: Int, func: Int => Int) = func(func(func(calkowita)))
  println("4a: " + trzykrotnie(2, i => i + 5))

  //5

  abstract class Osoba5(private val _imie: String, private val _nazwisko: String, private val _podatek: Double){
    def imie = _imie
    def nazwisko = _nazwisko
    def podatek =_podatek
  }
  trait Student extends Osoba5{
     override def podatek = 0.0
  }
  trait Nauczyciel extends Pracownik {
    override def podatek = 0.1
  }
  trait Pracownik extends Osoba5{
    private var _pensja = 0.0
    def pensja = _pensja
    def pensja_= (kwota: Double) : Unit = _pensja = kwota
    override def podatek = 0.2
  }

  val student = new Osoba5("Jan", "Student", 1) with Student
  val nauczyciel = new Osoba5("Adam", "Nauczyciel", 1) with Nauczyciel
  val pracownik = new Osoba5("Marek", "Pracownik", 1) with Pracownik

  println("5 podatek Studenta: " + student.podatek)
  println("5 podatek Nauczyciela: " + nauczyciel.podatek)
  println("5 podatek Pracownika: " + pracownik.podatek)

  var pracownikIStudent = new Osoba5("imie","nazwisko",1) with Pracownik with Student
  var studentIPracownik = new Osoba5("imie","nazwisko",1) with Student with Pracownik

  println("5 podatek pracownik i Student: " + pracownikIStudent.podatek)
  println("5 podatek student i Pracownik: " + studentIPracownik.podatek)

}


