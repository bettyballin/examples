class First():
    @staticmethod
    def some_function():
        print('this is a function')

class Second():
    def second_other_function(self):
        First.some_function()
        print('this is another function')

if __name__ == "__main__":
    second = Second()
    second.second_other_function()