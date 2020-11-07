# ITP4507 Assignment
> IVE 2020/21 Contemporary Topics in Software Engineering (ITP4507) Assignment

> Java Program: Business Set Lunch Ordering System

## Background
A company has a staff canteen which provide s catering service for its staff. Both eat in and take away services are provided by the canteen. Recently, due to the COVID 19, restrictions about canteen accommodations for eat in service have to be observed. T he company management wants to encourage the staff to stay in the company for lunch in order to lower the risk of infection. Therefore, the company has decided to subsidize the canteen to provide low price and high quality Business Lunch Sets via a new ordering system called Business Set Lunch Ordering System (BSLOS). Staff can ord er Business Lunch Set at an attractive price and the canteen will deliver the mea l to the staff office directly. 

Initially, the company will provide two kinds of Business Lunch Set : Chinese style and Western Style. The Chinese style set includes a main di sh with rice, a cup of Chinese style soup, and a cup of Oolong tea (hot or iced). The Western style set includes a main dish with one starch side dish which could be chosen from rice, spaghetti or French fries, a cup of Western style soup, and a cup of cof fee or tea (hot or iced). Only limited number of lunch set of each style will be available each day. The main dish of each style of lunch set will be change d on each day and the price of a lunch set may also be changed depending on the main dish. 

The menu will be available at 9:00am every day , showing the details including the price and the available count . After viewing the menu, the staff can choose either the Chinese style or the Western style and specify the relevant options, then enter staff number an d office location to make order. The available count will be updated accordingly when an order is received or cancelled. The orders will be handled on a first come first served basis and the delivery will start at 1:00 PM

Your system design should conform to the Open Closed P rinciple so that your design should easilybe extended to support new functions and the creation of new Lunch Sets, Soups and Drinks.

You are required to apply the following patterns in your system design
* Command Pattern to provide the “Edit menu”, “Show menu”, “Make order”, “Cancel order”, “List outstanding orders”, “Mark order as completed” functions
* Factory Method or Abstract Factory Pattern to create different kinds of Command objects and different kinds of Lunch Set.
* Memento Pattern to support the “Cancel order” function

## Features
1. Edit menu
2. Show menu display lunch sets with available counts)
3. Make order
4. Cancel order
5. List outstanding orders (orders which have not been completed
6. Mark order as completed

## Installation
### Setup
```
$ cd Portfolio
$ javac *.java
```

# Run the program
```
java Main
```