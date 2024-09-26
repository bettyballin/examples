import hashlib
import sys
import time


def try_all(words, target_hash):
    for word1 in words:
        hash_prefix = hashlib.sha512(word1 + b' ')
        for word2 in words:
            prefix_copy = hash_prefix.copy()
            prefix_copy.update(word2)
            # print(big_word)
            if prefix_copy.digest() == target_hash:
                print('Solution found')
                big_word = (word1 + b' ' + word2).decode('utf8')
                print(f'The word was: {big_word}')
                return


def read_all_words(filename):
    with open(filename, "rt") as f:
        return [line.strip().encode('utf-8') for line in f]


def get_test_hash(words):
    phrase = words[-2] + b' ' + words[-1]  # pick target towards end
    return hashlib.sha512(phrase).digest()


if __name__ == "__main__":
    words = read_all_words("02-dictionary.txt")
    TESTING = True
    if TESTING:
        words = words[:5000]  # reduce the size of the word list for testing only
        target_hash = get_test_hash(words)
    else:
        target_hash = bytes.fromhex(sys.argv[1].strip())
    start_time = time.time()
    try_all(words, target_hash)
    end_time = time.time()
    total_time = end_time - start_time
    print(f"Time taken: {round(total_time, 5)} seconds")
    print(f'{total_time / pow(len(words), 2)} seconds per hash')