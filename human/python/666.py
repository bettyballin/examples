class Person:  
  name = "John"
  age = 36
  country = "Norway"

  def __dir__(self):
    return ['__class__', '__delattr__', '__doc__', '__getattribute__', '__setattr__', '__subclasshook__']

p = Person()
print(dir(p))