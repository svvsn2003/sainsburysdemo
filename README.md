This project is built with follow tools/frameworks

a). Maven

b). Spring Core, Spring Context

c). Selenium Web Driver - Used Firefox driver, so before running you should make sure you have firefox installed in your machaine

d). Junit

e). Log4j

Installation instructions

1. clone the sainsburys demo project using github client from 
	https://github.com/svvsn2003/sainsburysdemo.git
	user:svvsn2003
	password:Password1
2. Download & install maven from https://maven.apache.org/download.cgi
2. check maven by command as below
	mvn --version
3. Go to the project down load location and rum
	mvn package
4. Goto {projectPath} location in commandline
5. java -cp target/sainsburysdemo.jar uk.co.sainsburys.controller.ProductListController

For your reference a packaged jar is already kept at {project_root}/sainsburysdemo.jar

so you can download and run the above command directly

NOTE:
I have tried to use other HTML parsers like Jsoup & HTMLUnit etc. But these frameworks has some limitations on Java Script executions

Sainisburs site requires Java Script to be enabled to load the content, so finally used Selenium web driver to get the content.
