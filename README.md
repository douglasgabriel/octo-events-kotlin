OctoEvents
===
App that listens Github events via webhooks and exposes an endpoint to filter it by issues.

> Since it is a learning project, some language structures has its usage forced, still these usages are open to discussions

### Tech stack

- [Kotlin](https://github.com/JetBrains/kotlin)
- [Javalin](https://github.com/tipsy/javalin)
- [Spring Framework (boot, data)](https://github.com/spring-projects)
- [PostgreSQL](https://www.postgresql.org/)
- [Apache Maven](https://maven.apache.org/)
- [JUnit](https://junit.org)

### Installation

Assuming that you already have the technologies above pre-installed (if needed), clone the repository and install its dependencies.

```bash
# clone this repository
$ git clone https://github.com/douglasgabriel/octo-events-kotlin.git

# go inside the repository
$ cd octo-events-kotlin

# install dependencies
$ mvn clean install
```

Also you may want to configure your local database by changing the `src/main/resources/application.properties` file

### Tests

The test suite can be executed by the following command

```bash
$ mvn test
```

### Running

To run locally this project you will need to provide a public URL that routes to your local endpoint, so, the use of [ngrok](https://ngrok.com/) is recommended here.

```bash
$ ngrok http 3000
``` 

> The default port is 3000, but it is possible to change it on file `src/main/resources/application.properties` 

Then it is possible to run the project by the following command:

```bash
$ mvn spring-boot:run
```

### Features

**Github Events listener**

The app defines the following endpoint to listen to Github events

```http request
[POST] /events
```
To integrate this APP with Github, you can navigate to the page of choosed repository, and then navigate to `settings -> Webhooks` and click on `Add Webhook` button. Finally you can fill the `Payload URL` field with `$public_url/events` and submit.

Now, when you create and update a Issue inside the choosed repository, the Github will request the given `Payload URL`, and then the APP will persist the Event and the associated Issue in database.


**Filter events by Issue**

The app also defines the following endpoint to get every Event of a particular Issue

```http request
# where number is the issue number
[GET] /issues/:number/events
```
