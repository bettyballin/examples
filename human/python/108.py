def word_to_int(word):
    return sum(ord(c) for c in word.strip())

with open("/usr/share/dict/words","rU") as dictionary: 
    with open("word_integer.txt", "a") as foo:
        while True:
            try:
                w1, w2 = next(dictionary), next(dictionary)
                foo.write(str(word_to_int(w1) ^ word_to_int(w2)) + '\n')
            except StopIteration:
                print("We've run out of words!")
                break