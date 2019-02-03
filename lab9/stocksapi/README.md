# Eureka service registry discovery

mvn clean package

Before you cf push, please make changes to following in the vars.yml
1. Set apps-domain to your apps domain

2. Set capi-uri to your API endpoint. You can locate it in Apps Manager > Tools

3. Verify that the vars.yml has the correct name for service registry.

cf push -f manifest.yml --vars-file vars.yml

If this command doesn't work then most likely your CF-CLI is old.
For mac:
  brew upgrade cf-cli
For others:
  refer to docs - https://docs.pivotal.io/pivotalcf/2-4/cf-cli/install-go-cli.html

---
Important lessons -

1. Pay attention to POM, notice the service-registry and starter-security

2. Take a look at StocksapiApplication.java. @EnableDiscoveryClient annotation helps the application register itself with service registry.

3. Learn how RestTemplate is initialized with @Bean and @LoadBalanced annotations.

4. Look at AcmeService.java. Observe how RestTemplate is ingested in the constructor.

5. Look at AcmeController.java. Observe how AcmeService is ingested in the constructor.

6. Finally, the instance of AcmeService is used to call the stocks-service.
---
