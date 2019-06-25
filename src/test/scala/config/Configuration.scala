package config

import com.typesafe.config.{Config, ConfigFactory}

object Configuration {

  // Command line arguments
  val environment: String = Option(System.getProperty("env")).getOrElse("ci")
  private val config: Config = ConfigFactory.load(s"$environment.application.properties")
  private val users: Config = ConfigFactory.load("user.properties")
  lazy val apiUrl: String = config.getString("apiUrl")
  lazy val stsUrl: String = config.getString("stsUrl")
  lazy val uiUrl: String = config.getString("uiUrl")

  val profileClientId: String = config.getString("profileClientId")

  val registerProfileUsers = Integer.getInteger("registerProfileUsers", config.getInt("registerProfileUsers")).toInt  val pxApiUsers = Integer.getInteger("pxApiUsers", config.getInt("pxApiUsers")).toInt

}
