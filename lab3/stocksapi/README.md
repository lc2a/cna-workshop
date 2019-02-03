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

Key learnings:

1. Explore AcmeController
Comment the @CrossOrigin annotation in one of the methods and see what happens.

2. Explore how RestTemplate is created

3. Pay attention to how RestTemplate is used to call backing service endpoint
