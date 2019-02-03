@UI frontended by Spring Cloud Gateway
cf push acme-ui-lab5 -m 64m --hostname acme-ui

// optional - don't do it unless asked by instructor
cf env acme-ui-lab5 TRUST_CERTS api.sys.dalycity.cf-app.com
cf restage acme-ui-lab5

---

In this lab we changed the app.js to use relative paths specified in the gateway routing rules.
