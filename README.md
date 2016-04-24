# MemoryISEN
*Created by Louis BOSSUT and Hugo COURME*

MemoryISEN is a Java EE application allowing two players to fight each other on a memory game. This project run using glassfish.

*Project realized in jan. 2016 during my training as engineer*

## Techs
* Java EE (Java 8)
* DAO pattern
* JPA
* JUnit tests
* Selenium
* Maven
* Glassfish server

## Feature
* Each game is random
* A token is generated at each game
* Each plays are saved
* Clicking on a card return it
* Each player have a score

## How to run it
Download the project and then uses the following command :
```
mvn glassfish:run
```
Now go to : [http://localhost:9090/memory/g/](http://localhost:9090/memory/g/)

###Web Tests
If you want to launch the web tests, you have to install the chrome driver. You can find it [here](https://sites.google.com/a/chromium.org/chromedriver/downloads).

Please install the `chromedriver.exe` in : `Memory_Install_Dir / driver`
