# idam-perf-tests
Performance Testing Scripts for the IDAM project

### Execute tests
From the command line:
* with default values:
 `mvn clean gatling:execute`
* to override with command line args:
`mvn clean gatling:test -Denv=dev -DidpUsers=1`
* to run a specific simualtion, for example:
`mvn clean gatling:test -Dgatling.simulationClass=simulations.RegisterUserIdamIdSimulation -Denv=ci`

Using the IDE Engine, we are able to set break points in the code and debug through. To do this, run `Engine` object from your IDE.

_Note: the default environment is configure to be CI should the system argument not be provided._


### Add properties for a new environment
1. Add a new file under resources folder, with the pattern : ${env}.application.properties
(e.g: dev.application properties).
2. To point the tests to that env, pass the arg -Denv=${env} when executing (e.g: -Denv=dev)

## Running specific simulations
LoginSimulation: this runs one-off test hitting the login endpoint with the given number of users
   ```
   mvn clean gatling:test -Dgatling.simulationClass=simulations.LoginUserIdamIdSimulation -Denv=ci -users=1
   ```

## Test Data

We have provisioned a number of users in the database for use with Lazy Migration performance testing. These details can be found under [Test data](https://idamuk.atlassian.net/wiki/spaces/ID/pages/853409956/Test+Data).   

These accounts are assumed to be available at the time of running. Should more data need to be provisioned, please refer to the [Postman collections](/postman) for test data generation.


### Build failure

Cause a build to fail if failure request response time is greater than responseTimeThreshold `-DresponseTimeThreshold` . Default value is 2000 .
e.g. `mvn clean gatling:test -Dsimulation=RegisterUser -Dusers=10 -DresponseTimeThreshold=1000`
