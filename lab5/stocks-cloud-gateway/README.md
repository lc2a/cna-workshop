#Spring Cloud Gateway

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

In this lab we will learn about Spring Cloud Gateway.
---
Spring Cloud Gateway aims to provide a simple, yet effective way to route to APIs and provide cross cutting concerns to them such as: security, monitoring/metrics, and resiliency.
---
Pay attention to StocksCloudGatewayApplication class.
The class has nothing more than SpringBootApplication annotation. And that is enough.
---
Pay attention to application.yml
See how routing rules are written to route traffic to acme-ui and stocksapi apps.
---
Once this gateway is deployed you will access the ACME application using the URL of the gateway.
This way all traffic to acme-ui and stocksapi is always from the the same domain from the point of view of the browser. There, it simply removed the CORS concerns.
