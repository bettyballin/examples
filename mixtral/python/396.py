import hashlib

def preprocess_dictionary():
    with open("02-dictionary.txt", "r") as fp:
        word_hashes = {}

        for line in fp:
            word = line.strip()
            hashed_word = hashlib.sha512(word.encode()).hexdigest()

            if word not in word_hashes:
                word_hashes[word] = set([hashed_word])

    return word_hashes

# Run the function
dictionary = preprocess_dictionary()
print(dictionary)