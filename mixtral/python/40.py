import os
from operator import xor

with open("/usr/share/dict/words", "r") as dictionary_file, \
     open("word_xors.txt", "a") as output_file:

    previous_int = None

    for line in dictionary_file:
        word = line.strip()

        # Convert the string to an integer
        int_word = int(word.encode('utf-8').hex(), 16)

        if previous_int is not None:
            xor_result = hex(xor(previous_int, int_word))

            output_file.write("{} ^ {} = {}\n".format(
                str(previous_int),
                word,
                xor_result
            ))

        previous_int = int_word