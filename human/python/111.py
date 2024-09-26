class Animal(object):
    pass

class Cat(Animal):
    pass

class Dog(Animal):
    pass

animals = {cls.__name__: cls for cls in Animal.__subclasses__()}

if __name__ == "__main__":
    for name, cls in animals.items():
        print(f"{name}: {cls}")