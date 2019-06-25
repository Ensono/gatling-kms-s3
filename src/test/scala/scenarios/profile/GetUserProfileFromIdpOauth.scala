package scenarios.profile

import config.Configuration.{IDAMID_APIKEY, apiUrl}
import io.gatling.core.Predef.ElFileBody
import io.gatling.http.Predef.http
import io.gatling.core.Predef._

object GetUserProfileFromIdpOauth {

  val httpConf = http
    .baseUrl(apiUrl)
    .header("Content-Type", "application/json")
    .authorizationHeader(s"APIKEY $IDAMID_APIKEY")

  val request = http("Get user profile from IDP using OAuth")
    .post("/v1/idp/oauth/get_user_profile")
    .body(ElFileBody("src/test/scala/bodies/IdpUserWithUsernameAndPasswordRequest.json"))
    .asJson
}
