import os

user_input = input("Please enter a path: ")
user_path = '/my/self/defined/path/' + user_input
abs_path = os.path.abspath(os.path.join('/', user_path))

if not abs_path.startswith("/my/self/defined/path"):
    raise ValueError("Invalid path")