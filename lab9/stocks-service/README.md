@Eureka Service Registry

mvn clean package

Before you cf push, please make changes to following in the vars.yml
1. Set apps-domain to your apps domain
2. Set capi-uri to your API endpoint. You can locate it in Apps Manager > Tools

---
Create service registry

1. cf m

2. cf cs p-service-registry standard acme-service-registry

3. watch cf s or cf s

4. 


If this command doesn't work then most likely your CF-CLI is old.
For mac:
  brew upgrade cf-cli
For others:
  refer to docs - https://docs.pivotal.io/pivotalcf/2-4/cf-cli/install-go-cli.html

In this lab we will learn about using data and JPA.
We modernize our stocks-service. Add business logic to it that will return random stock instead of a static one used in previous versions.
---
