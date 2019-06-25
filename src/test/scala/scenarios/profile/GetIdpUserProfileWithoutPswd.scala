package scenarios.profile

import config.Configuration.{apiUrl,IDAMID_APIKEY_EXT}
import io.gatling.core.Predef.{ElFileBody, _}
import io.gatling.http.Predef.http

object GetIdpUserProfileWithoutPswd {

  val httpConf = http
    .baseUrl(apiUrl)
    .header("Content-Type", "application/json")
    .authorizationHeader(s"APIKEY $IDAMID_APIKEY_EXT")

  val request = http("Get user profile from IDP without password provided")
    .post("/v1/idp/get_user_profile")
    .body(ElFileBody("src/test/scala/bodies/IdpUserWithUsernameRequest.json"))
    .asJson
}
