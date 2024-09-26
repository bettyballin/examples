import ast

def access_granted():
    print('Yay')

while True:
    secret = 25134231
    user_input = input('In: ')
    try:
        z = ast.literal_eval(user_input)
        if z == secret:
            access_granted()
    except (ValueError, SyntaxError):
        print("Invalid input")