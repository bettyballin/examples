
def find_a(res, b, c):
    for a in range(1, c):
        if pow(a, b, c) == res:
            return a
    return None  # If a is not found

# Example usage:
b = 3
c = 13
res = pow(3, b, c)  # res is 1
