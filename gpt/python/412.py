
def multiply(k, point=G):
    current = point
    binary = bin(k)[2:]  # Convert to binary and remove '0b' prefix.

    for char in binary[1:]:  # Skip the first binary digit.
        current = double(current)

