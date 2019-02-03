#Breaking the ACME monolith
In this lab we break the ACME monolith in three small applications
1. acme-ui: only UI, all static content
2. stocksapi: Backend for Frontend, API layer built for acme-ui. Built using Spring Boot
3. stocks-service: Business logic to provide stocks recommendations. Built using Spring Boot

All cross application interactions are over REST.

After successful deployment of all the three apps run

Pay attention to CORS concerns. Check with your lab instructor on what is CORS.
