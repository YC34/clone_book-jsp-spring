# Clone BOOK
### 참고한 책 : Spring Boot2 Recipes (Martin Deinum)




## INFO
* Environment
  * java version : 17
  * jdk : Temurin-17.0.11+9
  * Server : tomcat 11.0.0 
  * os : mac
  * idle : Intellij
  * build : maven
  * DB : 미정


## ISSUE
* javax -> jakarta로 변경.
  * jstl dependency 변경해줘야함. 
  * 변경 전
    ~~~
     <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>jstl</artifactId>
     </dependency>
    ~~~
  * 변경 후 
    ~~~
    <dependency>
      <groupId>jakarta.servlet</groupId>
      <artifactId>jakarta.servlet-api</artifactId>
    </dependency>
    <dependency>
      <groupId>org.glassfish.web</groupId>
      <artifactId>jakarta.servlet.jsp.jstl</artifactId>
    </dependency>
    <dependency>
      <groupId>jakarta.servlet.jsp.jstl</groupId>
      <artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
    </dependency>
    ~~~
    
