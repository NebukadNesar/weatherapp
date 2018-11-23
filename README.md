# weatherapp

-- Details --

Project has 5 maven module and one maven project as root directory,
Project name is 'app' in root dir pom file.

client module: serves static content and provides api

server module: get forecast data scheduled with 30 mins perion,  and insert it into database everytime a new data comes old ones removed.

utility module: provides xml parse functionality , used by server module to parse xml data, xml data is retreived from provided URL' and saved  into a file as iso-8859-1 format for special chars.

repository module: provides db access to postgres database

data module: provides the entity and relations model for repository and server module

There are 4 dependencies used: PostgressSQl dependency, Starter-Web, Spring-devtools, Actuator. 
Other dependencies are inter module dependencies.

We can use application by just running as spring boot app. But before that we have to run maven clean install and from root directory (app) maven update project (select all projects).
then we can run application as spring-boot app from client module.

CLient module is picked as the entiry point of application.
'WeatherClientController' is the api class
'WeatherClientMain' is the main class

Project will be served in the url : "http://localhost:5544/weather/" , it will direct a static html file for accessing the forecast information..
project is setup as follows:
port: 5544, 
root url: weather
application.properties: /client modules/resources folder/*
static web content: /client module /resources folder/public folder/index.html (pure javascript and html)
postgresql database name: 'weather'
postgres user/password: postgres/postgres  or weather/weather, from the application properties file in client...resources directory change passwrd and username accordingly.

How to use: 

After running app, there will be dates to select and cities availble
Select one date and click on desired city then press the button 'Get Forecast'
then it should puopulate and very basic table with details.

One Addition: we convert entity objects into public objects.


There ,however, are many bugs in the project:

a ) the database access from api is not effective and is very bad, relational queries should have been added to weatherrepository interface instead of code works
b ) the static content is not a well desinged web page, just plain html + javascript

