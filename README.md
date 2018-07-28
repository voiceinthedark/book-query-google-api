# Book Query (Or what should I read next?)

A book query application that will fetch data from the Google book web api.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

This project relies on 2 libraries; the Glide Api and the Apache commons collections.
Inside build.gradle:

```gradle
dependencies {
    ...
    implementation 'com.github.bumptech.glide:glide:4.7.1'
    // Glide v4 uses this new annotation processor -- see https://bumptech.github.io/glide/doc/generatedapi.html
    annotationProcessor 'com.github.bumptech.glide:compiler:4.7.1'
    
    // https://mvnrepository.com/artifact/org.apache.commons/commons-collections4
    implementation 'org.apache.commons:commons-collections4:4.1'

}

```

### Installing

Just clone the github repository to your working directory

```
git clone https://github.com/voiceinthedark/book-query-google-api.git
```

#### Special notes

In order to provide an API key to the google book api; I've included a public constructor to the class QueryBuilder that accepts a string key

``` java
public QueryBuilder(Context context, String apiKey){
        mContext = context;
        mApiKey = apiKey;
    }
```

Just initialize it with the key

```
QueryBuilder queryBuilder = new QueryBuilder(getContext(), "<My Api Key>");
String query = queryBuilder.encodeUrl(userQuery);
```

## Screens Demo

### Recently viewed books
![Imgur](https://i.imgur.com/PiHX02vl.png)

### Query list screen
![Imgur](https://i.imgur.com/Go7OhF6l.png)

### Book details screen
![Imgur](https://i.imgur.com/3NEcVT3l.png)

## Built With

* [Glide](https://github.com/bumptech/glide) - The image loading Framework
* [Maven](https://maven.apache.org/) - Dependency Management
* [Apache commons collections](https://commons.apache.org/proper/commons-collections/) - Used to apply a fixed size queueing system
* [Icons8](https://icons8.com/) - Used the App icon launcher

## Versioning

We use [Git 2.17.1](https://git-scm.com/) for versioning.  

## Authors

- **Firas Abbas** - [VoiceInTheDark](https://github.com/voiceinthedark)


## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE) file for details

## Acknowledgments

- [Udacity](https://www.udacity.com) - For their android development courses

