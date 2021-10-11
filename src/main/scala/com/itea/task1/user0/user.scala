package com.itea.task1.user0

/**
 * @see https://www.optics.dev/Monocle/
 */

case class User(id: Int,name: String, address: Address)
case class Address(street: String, number: Int, city: City)
case class City(title: String, state: String)

object UserApp extends App {

  val user: User = User(1, "Anton", Address("Khreshcatik", 1, City("Kyiv", "USA")))
  println( user ) // User(1,Anton,Address(Khreshcatik,1,City(Kyiv,USA)))

  val vlad = user.copy(name = "Vlad")
  println( vlad ) // User(1,Vlad,Address(Khreshcatik,1,City(Kyiv,USA)))

  // Without lenses
  val ua = user.copy(address = user.address.copy(city = user.address.city.copy(state = "Ukraine")))
  println( ua ) // User(1,Anton,Address(Khreshcatik,1,City(Kyiv,Ukraine)))

  import monocle.syntax.all._
  val uaMonocle = user.focus(_.address.city.state).replace("Russia")
  println( uaMonocle ) // User(1,Anton,Address(Khreshcatik,1,City(Kyiv,Russia)))

}
