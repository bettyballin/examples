
import hashlib
import sys
import time

def crack_hash(target_hash, dictionary_file):
    with open(dictionary_file, 'r') as file:
        words = [word.strip() for word in file]
    
    for word1 in words:
        for word2 in words:
            candidate = f"{word1} {word2}"
            if hashlib.sha512(candidate.encode()).hexdigest() == target_hash:
                return candidate
    return None

if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: python script.py
