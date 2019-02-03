# Externalizing configuration 

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

---
This lab has two parts.
---
In part1 we will learn externalizing config but locally within the application.yml.
Here we separate the banner from code and put in the yml file.
Pay attention to application.yml. This has the banner that will be used to greet the customer.

Now pay attention to AcmeController.
@Value annotation identifies what externalized configuration variable to pull the value from.
Please note it doesn't say anything about the application.yml or location of it.
This is the beauty of the opinionated Spring Boot framework.
Change the string in applicaiton.yml just for fun and try.
---

In part2 we will use production ready config server provided.
Spring Cloud Services tile deployed by your operators has a production ready configuration server that gets deployed on the same PAS (Pivotal Application Service) where you deploy your apps.
This brings all the manageability, resiliency and HA benefits that PAS brings to the table.

Before proceeding with the required code change we will ensure there is a service instance of a config service.
1. cf m -
This will show the marketplace and all available service types deployed on the platform.
2. cf s -
This will show service instances in the current org > space.
If you see an instance of p-config-server then you can ignore the steps below.
3. Take a look at cloud-config-uri.json. This file has a location of the GIT URL where configuration files are stored. The config server will retrieve configuration from there.
4. cf create-service p-config-server standard acme-config-server -c cloud-config-uri.json
5. watch cf s or cf s - to ensure the service instance is being created.

---
Now that the service instance is ready we will ensure it has the correct GIT location.
Login to Apps Manager. Select the org > space > services.
Select the config service you are going to use.
Click on the Manage link on the right corner.
You will require credentials to login to management console of the config server.
Once logged in you will see GIT location and number of config server instances currently running.
You can scale this config server if needed.
---

Now we are ready to make the code changes.
1. Go to POM and uncomment the dependency block that has spring-cloud-services-starter-config-client.
To simplify dependency management for a client app, each Spring Cloud Services project includes a starter: a maintained set of dependencies used by a client app, packaged in one Maven POM and included in the client app as a single dependency. This dependency is specifically built for application connecting to Pivotal managed SCS config server.

2. Pay attention to <dependencyManagement> section. This is a prereq for spring-cloud-services-starter dependencies.

3. mvn clean package

4. Go to vars.yml and update the name of the config-service

5. Review manifest-cloud-config.yml, there is a new entry to bind the app to service when it gets deployed.

6. cf push -f manifest-cloud-config.yml --vars-file vars.yml

7. Login to Apps Manager and ensure that stocksapi-lab8 is now bound to the right config service.

8. Access the application to ensure the banner has changed.

---
