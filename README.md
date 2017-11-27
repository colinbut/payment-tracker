# Payment Tracker

This is a Java program that keeps a record of payments. 

Initially, the program loads the following data from an initial input file:

e.g.

USD 1000  
HKD 100  
USD -100  
RMB 2000  
HKD 200  

Once started the program reads additional lines from the console. 

The program also outputs a grand total of the payments by currency once a minute

for example:

USD 900   
RMB 2000  
HKD 300  

(internally this is done by a scheduler - using a 3rd party scheduling library - Quartz Scheduler).

Optionally, a filename can be also be specified in the console on program startup. 

for instance:

```java
java -jar PaymentTracker.jar optional_input_file.txt
```

The user can then enter more lines into the console by typing a currency and amount and pressing enter. 

Every minute, the console outputs the net amounts of each currency. Should the net amount be 0, 
that currency is not displayed. 

When the user types "quit" or "q", the program exits.



#### File Format
The format of the file is one or more lines with Currency Code Amount like in the Sample input above, 
where the currency is any uppercase 3 letter code, such as USD, HKD, RMB, NZD, GBP etc. 


