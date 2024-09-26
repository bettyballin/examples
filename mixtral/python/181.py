class First():
    def some_other_function(self):
        print("This is some other function")

class Second():
    def __init__(self, first):
        self.first = first

    def __getattr__(self, name):
        return getattr(self.first, name)

# Usage
f = First()
s = Second(f)

# Now s can call methods from f
s.some_other_function()