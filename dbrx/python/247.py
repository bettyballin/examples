from string import Template

user_string = Template("Hello $name!")
my_string = user_string.safe_substitute(name="Homer")
print(my_string)  # Outputs: Hello Homer!

my_string = user_string.safe_substitute()
print(my_string)  # Outputs: Hello $name!