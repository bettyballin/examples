
class Dangerous:
    def __init__(self):
        self.secret = "This is a secret"

user_input = "Hello, {obj.secret}!"
obj = Dangerous()
print(user_input.format(obj=obj))  # This will print: Hello, This is a secret!

