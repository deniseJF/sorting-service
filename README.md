## SortingService

This project contains a SortingService that allows to sort a list of plain Java Beans.

## Current architecture

So, the idea was to follow the KISS principle, create the service in the simplest way possible,
with minimal dependencies.
That way, it's easy to deploy it with different combinations of frameworks and in any type of application.

It relies on [Maven](http://maven.apache.org) for building and dependency management, and uses the solid foundation of the
[Apache Commons APIs](http://commons.apache.org/) for the low-level functionalities.

There is a [sample client](https://github.com/deniseJF/booksortclient) provided that
demonstrates the functionality sorting book instances, but the service can sort any Java bean.

The configuration for the service can be a JSON file or an instance of a Configuration object.

### Sample JSON configuration

    {
        "configuration": [
            {
                "attribute": "edition", 
                "direction": "DESC"
            }, 
            {
                "attribute": "title", 
                "direction": "ASC"
            }
        ]
    }


### Recommended platform

The projects were developed targetting Java 7, using Oracle JDK 7.
