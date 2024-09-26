class SecureClass:
    def __init__(self):
        self.__name = "John"
        self.__age = 36
        self.__country = "Norway"

    # Override the dir() function for this class
    def __dir__(self):
        return ['__doc__', '__module__', '__name__', '__age__', '__country__']

    @property
    def name(self):
        raise AttributeError("'SecureClass' object has no attribute 'name'")

    @property
    def age(self):
        raise AttributeError("'SecureClass' object has no attribute 'age'")

    @property
    def country(self):
        raise AttributeError("'SecureClass' object has no attribute 'country'")

# Create an instance of SecureClass and print its attributes using dir()
p = SecureClass()

try:
    print(p.name)  # This will raise AttributeError because it's not in the allowed list.
except AttributeError as e:
    print(e)