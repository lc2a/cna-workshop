@Spring Boot data and JPA

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

In this lab we will learn about using data and JPA.
We modernize our stocks-service. Add business logic to it that will return random stock instead of a static one used in previous versions. 
---
Pay attention to POM.
POM has three new dependencies.
1. spring-boot-starter-data-jpa - Starter for using Spring Data JPA with Hibernate
2. h2 - In-memory H2 Database Engine. Very useful for development environment to test ideas really fast.
3. lombok - Extremely useful for defining POJOs with minimal code. Automatic Resource Management, automatic generation of getters, setters, equals, hashCode and toString, and more!

---
Pay attention to Stock.java.
Key annotations -
1. @Entity -  indicating that it is a JPA entity, will be mapped to a table named stock
2. @Getter @Setter - auto creates getter and setter methods for variables
3. @NoArgsConstructor - auto creates a default constructor
4. @Id - indicates Hibernate that this variable should be the primary key in the table
5. @GeneratedValue - indicates Hibernate to auto generate value for this variable

---
Pay attention to StockRepository.java
1. By extending CrudRepository, StockRepository inherits several methods for working with Customer persistence, including methods for saving, deleting, and finding Stock entities.
2. findBySymbol simply adds find query based on symbol. This is the beauty of the contract of findBy<Var>. All you need to do is to follow naming convention for your variables.
3. findRandomStock() indicates Hibernate to execute custom query thanks to @Query annotation.

---
Pay attention to StocksService.java
1. Take a look at how @Autowired annotation is used with constructor to inject an instance of StockRepository in this class.
2. Once repo instance available you can simply use it to save, delete or search entities in the table.
