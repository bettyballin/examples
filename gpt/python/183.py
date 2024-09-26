
def LetterFrequency(ciphertext):
    letter_frequency = {letter: 0 for letter in Letters}
    for letter in ciphertext.upper():
        if letter in Letters:
            letter_frequency[letter] += 1
    # Sort the dictionary by value in descending order
    sorted_letter_freq = dict(sorted(letter_frequency.items(), key=lambda item: item[1], reverse=True))
    return sorted_letter_freq

def ExtractNthLetters(text, n):
    return text[::n]

Ciphertext = input("What is the cipher text? ")
Letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

# Print the frequencies in descending order
frequencies = LetterFrequency(Ciphertext)
for letter, freq in frequencies.items():
    print(f'{letter}: {freq}')

# Example usage for extracting every third letter:
extracted_letters = ExtractNthLetters(Ciphertext.replace(' ', ''), 3)  # Assuming you want to ignore spaces
print(extracted_letters)

