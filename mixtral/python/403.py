def multiply(k, point=G):
    current = point

    binary_str = bin(k)[2:]

    for i in binary_str[1:]:
        current = double(current)

        if i == "1":
            current = add(current, point)

    return current

# Define missing functions and variable
def double(point):
    # Your implementation of double function
    pass

def add(point1, point2):
    # Your implementation of add function
    pass

G = None  # Define the variable G