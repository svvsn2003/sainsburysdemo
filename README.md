This project is built with following libraries/tools/frameworks. Please note this is just to let you know that I can work on some of below techniques

a). Maven - Build framework

b). Spring Core, Spring Context - Spring IOC for dependency injection

c). Selenium Web Driver - Used Firefox driver, so before running you should make sure you have firefox installed in your machaine

d). Google geson library - For object to json conversion

e). Junit - Unit tests

f). Mockito - Mock/behaviour tests

e). Log4j - Logging info/debug

f) JDK 1.7
g) Git Hub - Versioning control

Installation instructions

1. Set the JAVA_HOME = JDK 1.7 home environment system varaible
2. Set the Path with JRE bin
3. You need git client, you may use eclispe plugin
3. clone the sainsburys demo project using github client from 
	https://github.com/svvsn2003/sainsburysdemo.git
	user:svvsn2003
	password:Password1
4. Download & install maven from https://maven.apache.org/download.cgi or you can use eclipse plugin
5. check maven by command as below
	mvn --version
6. Go to the project down load location and rum
	mvn package
7. Verify you have sainsburysdemo.jar created at {project_root}/target
8. Goto {projectPath} location in commandline
  java -cp target/sainsburysdemo.jar uk.co.sainsburys.controller.ProductListController



NOTE:
I have tried to use other browser less HTML parsers like Jsoup & HTMLUnit, Selenium HTMLUnitDriver etc. But these frameworks has some limitations on Java Script executions and which are not fitting for sainsburys web pages, as it requires JS enabled page loads.

Sainisburs site requires Java Script to be enabled to load the content, so finally used Selenium web driver to get the content.

Know issues:
1. Due to time limitations not worked on all unit tests
2. JSON total price is not calculated

