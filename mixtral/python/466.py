class Person:
    name = "John"
    age = 36
    country = "Norway"

    def __init__(self):
        self.__private_attr = 'secret'

    def __dir__(self):
        return ['__doc__', 'name']

p1 = Person()
print(dir(Person))  
print(dir(p1))