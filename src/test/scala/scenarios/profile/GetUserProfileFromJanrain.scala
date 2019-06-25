package scenarios.profile

import config.Configuration.{JANRAIN_APPLICATION_CLIENT_ID, JANRAIN_APPLICATION_CLIENT_SECRET, janrainUrl}
import io.gatling.http.Predef.http
import io.gatling.core.Predef._

object GetUserProfileFromJanrain {

  val httpConf = http
    .baseUrl(janrainUrl)

  val request = http("Get user profile from Janrain")
    .get("/entity.find")
    .basicAuth(username = JANRAIN_APPLICATION_CLIENT_ID, password = JANRAIN_APPLICATION_CLIENT_SECRET)
    .queryParam("type_name", "user")
    .queryParam("filter", "email='${userEmail}'")
    .asFormUrlEncoded
    .disableFollowRedirect
}
