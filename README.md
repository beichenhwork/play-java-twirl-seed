# Play!Java Ebean Seed
![GitHub](https://img.shields.io/github/license/ECMGit/play-java-ebean-seed)

update date: 03/09/2023  
Author: Beichen Hu[beichenh@smu.edu], Junhao Shen [junhaos@smu.edu]

OS support:
- MacOS Ventura 13.0 Apple M2 Chips
- Ubuntu 20.04

## Prerequisite:
- Java version: 11.0.18
- Scala Version: 2.13.10
- Play! Framework version: 2.18.19
- sbt version: 1.7.2

Version compatibility table[https://docs.scala-lang.org/overviews/jdk-compatibility/overview.html]

## Plugins
- Dependency Injection: [guice](https://www.playframework.com/documentation/2.8.x/JavaDependencyInjection)

- Calling REST APIs with Play WS[javaWS](https://www.playframework.com/documentation/2.8.x/JavaWS)

- The Play cache API[ehcache](https://www.playframework.com/documentation/2.8.x/JavaCache)

## Project Layout
```
├── README.md                              # README first     
├── app                                    # write your code under this folder
│   ├── controllers                        # controller module
│   │   ├── HomeController.java            # home controller, you can define any default page here
│   │   └── UserController.java            # user controller, define user pages here
│   ├── models                             # data model module
│   │   └── User.java                      # data model User
│   ├── services                           # service module[optional]
│   │   └── UserService.java
│   ├── utils                              # utility module, for any utility functions(you don't have to change, just use it)
│   │   ├── Constants.java                 # save all constants
│   │   ├── HttpResponse.java              # define and save all http response
│   │   ├── HttpUtil.java                  # utility functions for http
│   │   └── RESTfulCalls.java              # handle all RESTfull calls to backend
│   └── views                              # view module, all your html files
│       ├── detail.scala.html
│       ├── edit.scala.html
│       ├── login.scala.html
│       └── register.scala.html
├── build.sbt                              # build file, define all dependencies here
├── conf                                   # configuration files
│   ├── application.conf
│   ├── logback.xml
│   └── routes                             # define all routes here
├── logs
├── project
│   ├── build.properties                   # build properties, define sbt version,etc.
│   ├── plugins.sbt                        # define preload plugins, play framework, etc.
│   └── project
└── public                                 # public files, css, js, images, etc.
    ├── images
    ├── javascripts
    └── stylesheets
```

## Additional Resources:
[Session & Flash Scope](https://www.playframework.com/documentation/2.8.x/JavaSessionFlash#How-it-is-different-in-Play)  
[Protecting against Cross Site Request Forgery](https://www.playframework.com/documentation/2.8.x/JavaCsrf)