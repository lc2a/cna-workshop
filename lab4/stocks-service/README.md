#Actuator

mvn clean package

Before you cf push, please make changes to following in the vars.yml
1. Set apps-domain to your apps domain
2. Set capi-uri to your API endpoint. You can locate it in Apps Manager > Tools

cf push -f manifest.yml --vars-file vars.yml

If this command doesn't work then most likely your CF-CLI is old.
For mac:
  brew upgrade cf-cli
For others:
  refer to docs - https://docs.pivotal.io/pivotalcf/2-4/cf-cli/install-go-cli.html

In this lab we will learn about Actuator.
---
Pay attention to POM, there is a new dependency for Actuator.
An actuator is a manufacturing term that refers to a mechanical device for moving or controlling something. Actuators can generate a large amount of motion from a small change.
---
Actuator module provides all of Spring Boot’s production-ready features.
Actuator endpoints let you monitor and interact with your application. Spring Boot includes a number of built-in endpoints and lets you add your own. For example, the health endpoint provides basic application health information.
---
Pay attention to application.properties under resources.
management.endpoints.web.exposure.include - Endpoint IDs that should be included or '*' for all.
management.endpoint.health.show-details - When to show full health details.
management.cloudfoundry.enabled - Whether to enable extended Cloud Foundry actuator endpoints.
management.cloudfoundry.skip-ssl-validation - Whether to skip SSL verification for Cloud Foundry actuator endpoint security calls.
---
Try actuator endpoints
/actuator/health
/actuator/env
---
Pay attention to App Manager console for stocks-service app and stocksapi app.
Do you see any difference when you drill down to each of these two apps?
Do you notice that the stocks-service app has Spring Boot logo, app health, etc additional options
that stocksapi doesn't have?
---
Optional - try to disable an endpoint
Add following to application.properties, rebuild and redeploy the app. 
management.endpoints.web.exposure.exclude=env
This will disable env endpoint.
In production you may not want to expose the runtime environment.
---
Custom actuator endpoints
What if your application needs important business metrics that are consumed by business analytics solution?
Actuator allows you to create custom metrics that can be easily exposed from within the application.
Pay attention to DailyRevenueEndpoint class
Access the business metric using /actuator/daily-revenue
