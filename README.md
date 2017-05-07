# Transaction Monitoring Async RESTful Service

The main purpose of this application is to monitor transactions with in 60 
 seconds of time.


## How to Build the Project
```
mvn clean
mvn package
```

## How to Run the Project

```
java -jar target/TransactionMonitor-0.0.1-SNAPSHOT.jar
```

## Tasks

    (1) Creating the transactions

    POST /transactions
    
    Body :
    {
        "amount" : 12.3,
        "timestamp" : 1492935639604
    }
    
    * amount is double value
    * timestamp is long value specifying UNIX time format
    * Returns : Empty body with 201 response
    
    ---------------------------------------------------
    
    (2) Get the transaction statistics
    
    GET /statistics
    
    Body :
    {
        "sum" : 1000,
        "avg" : 100,
        "max" : 200,
        "min" : 10,
        "count" : 10
    }
    
    * sum is double value (total amount)
    * avg is double value (average amount)
    * max is double value (max transaction value)
    * min is double value (min transaction value)
    * count is long value (number of transactions)
    
 # TODO
    * Immutability - Fixed
    * BUG JVM object uniqueness :( - http://www.javaworld.com/article/2073618/java-s-system-identityhashcode.html- Fixed introduced concurrent HashMap and Atomic Integer
    * Exception handling
    * Add Spring Security features
    * Keep the constant memory consumption
    * Resolve the thread hanging situations
    * Monitor the transactions - UI Level
    
 # READ MORE
    
    * http://bigocheatsheet.com/
    * https://crunchify.com/java-concurrentnavigablemap-and-concurrentskiplistmap-example-with-all-details/
 
 # Useful Link
 ![alt text](https://raw.githubusercontent.com/sampathsl/TransactionMonitor/master/images/1.jpg)
 
