# Preditor-Prey - Bears and Fish

## Source of these questions: Unknown.
I found these questions in many places on the internet, but none of the locations specified a source.  If you know the source (the text book, or whatever), please let me know.


## P-2.31
Write a program (in Java, Basic, Python, C++ or whatever language you like) to simulate an ecosystem containing two types of creatures, bears and fish. The ecosystem consists of a river, which is modeled as a relatively large array. Each cell of the array should contain an Animal object, which can be a Bear object, a Fish object, or null. In each time step, based on a random process, each animal either attempts to move into an adjacent array cell or stay where it is. If two animals of the same type are about to collide in the same cell, then they stay where they are, but they create a new instance of that type of animal, which is placed in a random empty (i.e., previously null) cell in the array. If a bear and a fish collide, however, then the fish dies (i.e., it disappears). Use actual object creation, via the new operator, to model the creation of new objects, and provide a visualization of the array after each time step.


## P-2.32
Write a simulator as in the previous project, but add a boolean gender field and a floating-point strength field to each Animal object. Now, if two animals of the same type try to collide, then they only create a new instance of that type of animal if they are of different genders. Otherwise, if two animals of the same type and gender try to collide, then only the one of larger strength survives.
