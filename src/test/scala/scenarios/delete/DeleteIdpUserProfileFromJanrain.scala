package scenarios.delete

import config.Configuration.{JANRAIN_APPLICATION_CLIENT_ID, JANRAIN_APPLICATION_CLIENT_SECRET, janrainUrl}
import io.gatling.http.Predef.http
import io.gatling.core.Predef._

object DeleteIdpUserProfileFromJanrain {

  val httpConf = http
    .baseUrl(janrainUrl)

  val request = http("Delete IDP user profile from Janrain")
    .post("/entity.delete")
    .basicAuth(username = JANRAIN_APPLICATION_CLIENT_ID, password = JANRAIN_APPLICATION_CLIENT_SECRET)
    .queryParam("type_name", "user")
    .queryParam("uuid", "${uuid}")
    .asFormUrlEncoded
    .disableFollowRedirect
}
