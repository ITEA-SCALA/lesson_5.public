package com.itea.di.macwire

class DatabaseAccess() { println("DatabaseAccess") }
class SecurityFilter() { println("SecurityFilter") }
class UserFinder(databaseAccess: DatabaseAccess, securityFilter: SecurityFilter) { println("UserFinder") }
class UserStatusReader(userFinder: UserFinder) { println("UserStatusReader") }

class UserModule {
  import com.softwaremill.macwire._

  lazy val theDatabaseAccess   = wire[DatabaseAccess]
  lazy val theSecurityFilter   = wire[SecurityFilter]
  lazy val theUserFinder       = wire[UserFinder]
  lazy val theUserStatusReader = wire[UserStatusReader]
}

object UserModule extends App {
  val userModule: UserModule = new UserModule()
//  userModule.theDatabaseAccess
  //TODO  DatabaseAccess

//  userModule.theSecurityFilter
  //TODO  SecurityFilter

  userModule.theUserFinder
  //TODO  DatabaseAccess
  //TODO  SecurityFilter
  //TODO  UserFinder

//  userModule.theUserStatusReader
  //TODO  DatabaseAccess
  //TODO  SecurityFilter
  //TODO  UserFinder
  //TODO  UserStatusReader
}
