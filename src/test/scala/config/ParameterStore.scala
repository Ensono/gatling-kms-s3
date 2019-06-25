package config

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain
import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagementClientBuilder
import com.amazonaws.services.simplesystemsmanagement.model.GetParameterRequest


object ParameterStore {
  private val credentials = DefaultAWSCredentialsProviderChain.getInstance
  private val simpleSystemsManagementClient = AWSSimpleSystemsManagementClientBuilder.standard.withCredentials(credentials).withRegion("eu-west-2").build

  def getParameterFromSSMByName(parameterKey: String): String = {
    val parameterRequest = new GetParameterRequest
    parameterRequest.withName(parameterKey).setWithDecryption(true)
    try {
      val parameterResult = simpleSystemsManagementClient.getParameter(parameterRequest)
      parameterResult.getParameter.getValue
    } catch {
      case e: Exception =>
        println(e.getMessage)
        e.getMessage
    }
  }
}