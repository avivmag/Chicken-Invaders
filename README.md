# Chicken-invaders

A simple 'chicken invaders' based game built in java with swing graphic api. 
A detailed description for how to play this game can be found [HERE](https://www.cs.bgu.ac.il/~oosd152/wiki.files/Assignment4_oosd152_Update_01_06.pdf).

## Visitor pattern

This game is a great example for integrating the Visitor pattern via double dispatch for interaction between two dynamic typed instances.
In our case, the interaction is between the chickens and the shots in the game.
In this assignment, we want to have a high diversity of chickens but only four types of shots.
Thus, the chicken is chosen to implement the visitor role, while the shot will play the role of an element.
The meaning of such decision is that it will be much easier to add some new kind of chickens rather than new kind of shots.
Be aware that a side from a correct way (object oriented) to implement such a game, we degraded some of the bugs from runtime exceptions level to compilation time errors. we done that by evading the use of the `instanceof` keyword, and instead being more definite about the dynamic types we use.

This game has been done in pairs as part of an assignment in "Principles of Object Oriented Programming" course at Ben-Gurion University in 2015.

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

* The actual assignment: https://www.cs.bgu.ac.il/~oosd152/wiki.files/Assignment4_oosd152_Update_01_06.pdf
* https://en.wikipedia.org/wiki/Double_dispatch
* https://en.wikipedia.org/wiki/Visitor_pattern | https://sourcemaking.com/design_patterns/visitor
