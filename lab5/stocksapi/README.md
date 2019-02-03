# ACME Stocks API layer

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

Pay attention to AcmeController class.
See that the CrossOrigin annotation is removed from the REST methods.

You may wonder why did we not have CrossOrigin annotation for the stocks-service app.
The reason is simply this - under no circumstances the stocks-service app will be called
from the client browser. It will always be called from the stocksapi app on the server side.
