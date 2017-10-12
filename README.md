# Chicken-invaders

A simple 'chicken invaders' based game built in java with swing graphic api. 

The development of this game was done in pairs as part of an assignment in "Principles of Object Oriented Programming" course at Ben-Gurion University in 2015.

A detailed description for how to play this game can be found in the desciption of the attached assignment - section 2,
currently only hebrew version of the description is available.

## Visitor pattern

This game is a great example for integrating the Visitor pattern via double dispatch for interaction between two dynamic typed instances.
In our case, the interaction is between the chickens and the shots in the game.
In this assignment, we want to have a high diversity of chickens but only four types of shots.
Thus, the chicken is chosen to implement the visitor role, while the shot will play the role of an element.
The meaning of such decision is that it will be much easier to add new kinds of chickens rather than new kinds of shots.
Be aware that aside from a correct way (object oriented) to implement such a game, we degraded some of the bugs from runtime exceptions level to compilation time errors. we've done that by evading the use of the `instanceof` keyword, and instead we've been more definite about the dynamic types we use.

## Getting Started
### Prerequisites

1. Java SE Runtime Environment 8 (at least), 
can be found: http://www.oracle.com/technetwork/java/javase/downloads/index.html

## Running game

From Terminal/cmd type:
```
java -jar path_of_clone/bin/Chicken_invaders.jar
```

## Useful links

* The original source of the assignment: https://www.cs.bgu.ac.il/~oosd152/wiki.files/Assignment4_oosd152_Update_01_06.pdf
* https://en.wikipedia.org/wiki/Double_dispatch
* https://en.wikipedia.org/wiki/Visitor_pattern | https://sourcemaking.com/design_patterns/visitor
