
class Person:
    name = "John"
    age = 36
    country = "Norway"

    def __dir__(self):
        # You can customize the list as per your requirements
        return ['__class__', '__delattr__', '__dict__', '__doc__']

person = Person()
print(dir(person))

