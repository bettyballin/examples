animals = {}

def registered(cls):
    animals[cls.__name__] = cls
    return cls

@registered
class Cat():
    pass

@registered
class Dog():
    pass

def main():
    print(animals)

if __name__ == "__main__":
    main()