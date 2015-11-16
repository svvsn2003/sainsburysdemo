This project is built with following libraries/tools/frameworks

a). Maven - Build framework

b). Spring Core, Spring Context - Spring IOC for dependency injection

c). Selenium Web Driver - Used Firefox driver, so before running you should make sure you have firefox installed in your machaine

d). Google geson library - For object to json conversion

e). Junit - Unit tests

f). Mockito - Mock/behaviour tests

e). Log4j - Logging info/debug

f) JDK 1.7

Installation instructions

1. Set the JAVA_HOME = JDK 1.7 home environment system varaible
2. Set the Path with JRE bin
3. clone the sainsburys demo project using github client from 
	https://github.com/svvsn2003/sainsburysdemo.git
	user:svvsn2003
	password:Password1
4. Download & install maven from https://maven.apache.org/download.cgi
5. check maven by command as below
	mvn --version
6. Go to the project down load location and rum
	mvn package
7. Goto {projectPath} location in commandline
8. java -cp target/sainsburysdemo.jar uk.co.sainsburys.controller.ProductListController

For your reference a packaged jar is already kept at {project_root}/sainsburysdemo.jar

so you can download and run the above command directly

NOTE:
I have tried to use other HTML parsers like Jsoup & HTMLUnit etc. But these frameworks has some limitations on Java Script executions

Sainisburs site requires Java Script to be enabled to load the content, so finally used Selenium web driver to get the content.
