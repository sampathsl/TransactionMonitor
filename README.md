# N26 Transaction Monitoring Async RESTful Service

The main purpose of this application is to monitor transactions with in 60 
 seconds of time.


## How to Build the Project
```
mvn clean
mvn pakage
mvn clean install
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
