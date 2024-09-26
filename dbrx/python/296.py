import hashlib
import sys
import time
from itertools import product

def crack_hash(word, target):
    dict_hash = hashlib.sha512(word.encode())
    if dict_hash.hexdigest() == target:
        return True, word
    else:
        return False, None

if __name__ == "__main__":
    target_hash = sys.argv[1].strip()

    with open("02-dictionary.txt", "r") as fp:
        words = [word.strip() for word in fp]

    start_time = time.time()
    for big_word in product(words, repeat=2):
        soln_found, soln_word = crack_hash(' '.join(big_word), target_hash)
        if soln_found:
            print('Solution found')
            print(f"The word was: {soln_word}")
            break

    end_time = time.time()
    total_time = end_time - start_time
    print(f"Time taken: {round(total_time, 5)} seconds")