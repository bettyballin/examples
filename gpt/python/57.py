
def spy_code(txt, n):
    result = ''
    for i in txt:
        if i.isalpha():  # Check if the character is a letter
            if i.islower():  # Check if it's a lowercase letter
                c = chr((ord(i) - ord('a') + n) % 26 + ord('a'))
            else:  # Otherwise, it must be an uppercase letter
                c = chr((ord(i) - ord('A') + n) % 26 + ord('A'))
            result += c
        else:
            result += i  # Leave non-letter characters unchanged
    return result

# Example usage:
encrypted_message = spy_code('abord mission, dont atk teacher!', 5)
print(encrypted_message)

