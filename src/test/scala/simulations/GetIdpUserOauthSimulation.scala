package simulations

import config.Configuration.{idpApiUsers, rampUpPeriod, responseTimeThreshold}
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scenarios.profile.GetUserProfileFromIdpOauth

import scala.concurrent.duration._

class GetIdpUserOauthSimulation extends Simulation {

  val scn = scenario("Get user profile from IDP using OAuth scenario")
    .exec(GetUserProfileFromIdpOauth.request.check(status.is(200)));

  val load = rampUsers(idpApiUsers).during(rampUpPeriod minutes)

  // Checking the API gets the 200 within the threshold limit response time
  setUp(scn.inject(load))
    .assertions(global.responseTime.max.lt(responseTimeThreshold)
      ,details("Get user profile from IDP using OAuth").successfulRequests.percent.gte(100))
    .protocols(GetUserProfileFromIdpOauth.httpConf)
}
