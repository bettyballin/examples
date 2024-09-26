def cipher(string):
    encrypted = ""
    for letter in string:
        encrypted += chr(ord(letter)+4)
    return encrypted


#Decipher function
def decipher(encrypted):
    NewString  = ""
    for letter in encrypted:
        NewString += chr(ord(letter)-4)

    return NewString


def main():
    string = input("enter your string here: ")
    encrypted=cipher(string)
    print(encrypted)
    decyphered=decipher(encrypted)
    print(decyphered)

main()