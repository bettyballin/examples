
def encrypt(text, key):
    if key == 1:
        return text

    rail = [''] * key
    row, step = 0, 1

    for char in text:
        rail[row] += char
        row += step

        if row == 0 or row == key - 1:
            step = -step  # Change direction at the top and bottom rail.

    return ''.join(rail)

def decrypt(cipher, key):
    if key == 1:
        return cipher

    length = len(cipher)
    rail = [[] for _ in range(key)]

    # Determine the size of each rail
    row, step = 0, 1
    for char in cipher:
        rail[row].append(None)  # Placeholder for characters
        row += step

        if row == 0 or row == key - 1:
            step = -step  # Change direction at the top and bottom rail.

    # Fill the rails with the actual characters
    index = 0
    for i
