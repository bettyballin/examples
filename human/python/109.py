class Dog:
    pass

class Cat:
    pass

which_animal = "Dog"

animal_cls = globals()[which_animal]
if animal_cls.__module__ != __name__:
    raise TypeError('Not a class defined in this module!')
animal1 = animal_cls()