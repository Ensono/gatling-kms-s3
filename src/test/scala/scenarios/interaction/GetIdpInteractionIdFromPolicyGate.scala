package scenarios.interaction

import config.Configuration.{idpClientId, stsUrl, uiUrl}
import io.gatling.http.Predef.http
import io.gatling.core.Predef._

object GetIdpInteractionIdFromPolicyGate {

  val httpConf = http
    .baseUrl(stsUrl)

  val request = http("Get IDP interaction ID from Policy Gate")
    .get("/auth")
    .queryParam("client_id", idpClientId)
    .queryParam("response_type", "code")
    .queryParam("nonce", "fsdfdsfsd")
    .queryParam("redirect_uri", uiUrl + "/success")
    .queryParam("scope", "openid+profile+email")
    .queryParam("show_screen", "login")
    .disableUrlEncoding
    .disableFollowRedirect

}
