try:
    user_input = input("Enter Something : ")
    exec(user_input)
except Exception as e:
    print("An error occurred: ", str(e))