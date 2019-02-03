@Introducing API Gateway

In this lab you will learn a key lesson in breaking the monolith.

Remember in lab3 we added CrossOrigin annotation?
Imagine you have to do that for every upstream application that accesses the API.
Besides, it is a bad practice due to tight coupling it introduces.

This is where we bring in important construct in distributed microservices architecture - API Gateway.

API gateway helps you isolate downstream applications from clients.
It is the place where you establish your API contracts with the application consumer.
API gateways can be used as a facade for your downstream apps.
This way you can modernize the downstream monoliths without affecting the upstream clients.

API gateways can also be used for addressing cross-cutting concerns such as security, rate limiting, etc.

---
We added a new application - stocks-cloud-gateway.
In this case the gateway is used to frontend all the traffic to the ACME application.
This gateway does something very simple yet powerful.
It provides routing to ACME microservices using single client facing URL.
Following are the simple routing rules -
1. Any request to / will be redirected to acme-ui
2. Any request to /stocks will be redirected to stocksapi

This solves major problem of CORS without having to introduce @CrossOrigin in APIs called from client.
Thanks to the gateway layer browser never has to make cross-domain calls.

---

Now follow the README for apps in this order -
1. stocks-cloud-gateway - a kotlin app with minimal code Spring Cloud Gateway implementation
2. acme-ui - changes to use relative path rather than actual application URLs
3. stocksapi - removed CrossOrigin
