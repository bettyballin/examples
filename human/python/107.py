def word_to_int(word):
    return sum(ord(i) for i in word.strip())

# Test the function
word = input("Enter a word: ")
print(word_to_int(word))