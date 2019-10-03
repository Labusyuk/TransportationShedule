# Transportation Shedule
Java EE. Logistic system showcase. 
Online showcase the cinema
###### Instructions to run the project:

1. Download and install jdk 1.8, Git, Apache Tomcat.
2. Clone project: git clone https://github.com/Labusyuk/TransportationShedule.git
3. cd to project folder and mvnw clean install
4. Maybe you must install some library in Tomcat lib folder, its: commons-collections, jsoup. In my case there is C:\Program Files\Apache Software Foundation\Tomcat 9.0\lib.
4. Run with Tomcat

###### Note: 
Еhe program stores transport data, routes, stops, schedules in collections. Parsing takes a long time. Therefore, it is executed only at the first access to resources and stored for one hour. The first treatment takes about 1-4 minutes.
There's really a lot of information out there, at each stop, on your schedule: weekdays and weekends. Routes in one transport in different directions are regarded as different.

###### Entity relationship diagram database

![Image of Yaktocat](https://github.com/Labusyuk/ShowcaseTheCinema/blob/master/CinemaBDModelFirst.png?raw=true)

