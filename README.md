# Predator-Prey - Bears and Fish

## Source of these questions: **Unknown.**
I found questions P-2.31 and P-2.32 in many places on the internet, but none of the locations specified an original source.  If you know the original source (the text book, original author, or whatever), please let me know. :smiley:


## P-2.31
Write a Java program [*or Basic, Python, C++ or whatever language you like - Moose*] to simulate an ecosystem containing two types of creatures, bears and fish. The ecosystem consists of a river, which is modeled as a relatively large array. Each cell of the array should contain an Animal object, which can be a Bear object, a Fish object, or null. In each time step, based on a random process, each animal either attempts to move into an adjacent array cell or stay where it is. If two animals of the same type are about to collide in the same cell, then they stay where they are, but they create a new instance of that type of animal, which is placed in a random empty (i.e., previously null) cell in the array. If a bear and a fish collide, however, then the fish dies (i.e., it disappears). Use actual object creation, via the new operator, to model the creation of new objects, and provide a visualization of the array after each time step.


## P-2.32
Write a simulator as in the previous project, but add a boolean gender field and a floating-point strength field to each Animal object. Now, if two animals of the same type try to collide, then they only create a new instance of that type of animal if they are of different genders. Otherwise, if two animals of the same type and gender try to collide, then only the one of larger strength survives.


## P-2.33 - by Moose O
* Add GUI interface to your simulation.
* Add life span, mortality rates, birth rates, etc.
* Add the ability to speed up time or slow down time
* Add other types of animals
* Add zones - bear only zones (land), fish only zones (deep water)



## YouTube Videos Working through this problem:

### Predator-Prey - Bears and Fish - Part 1
* [https://www.youtube.com/watch?v=NhDvmoOW5gc](https://www.youtube.com/watch?v=NhDvmoOW5gc&list=PLfKyhM9sqOY5bHuIgk_taSa7qEBh8EPce)

### Predator-Prey - Bears and Fish - Part 2
* [https://www.youtube.com/watch?v=Pz9kRxFOs28](https://www.youtube.com/watch?v=Pz9kRxFOs28&list=PLfKyhM9sqOY5bHuIgk_taSa7qEBh8EPce)
