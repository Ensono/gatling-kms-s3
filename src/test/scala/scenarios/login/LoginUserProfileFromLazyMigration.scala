package scenarios.login

import config.Configuration.{stsUrl,idpLmUserPassword}
import io.gatling.http.Predef.http
import io.gatling.core.Predef._

object LoginUserProfileFromLazyMigration {

  val httpConf = http
    .baseUrl(stsUrl)

  val request = http("Login User")
    .post("/interaction/v2/${interactionId}/login")
    .formParamMap(Map("email" -> "${userEmail}", "password" -> idpLmUserPassword))
    .disableFollowRedirect
}
