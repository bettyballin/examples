import os

def xor_words(word1, word2):
    return int.from_bytes(bytes.fromhex(hex(int(word1.encode('utf-8').hex(), 16) ^ int(word2.encode('utf-8').hex(), 16))[2:]), 'big')

dictionary = open("/usr/share/dict/words", "r")
output_file = open("word_xor.txt", "w")

dictionary_lines = dictionary.readlines()
for i, word1 in enumerate(dictionary_lines):
    for j, word2 in enumerate(dictionary_lines[i+1:]):
        output_file.write(f"{xor_words(word1.strip(), word2.strip())}\n")

dictionary.close()
output_file.close()