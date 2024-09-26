def deobs_filename(text):
    return ''.join(chr(ord(char) - 5) for char in text)

if __name__ == "__main__":
    text = input("Enter the text to deobfuscate: ")
    print(deobs_filename(text))