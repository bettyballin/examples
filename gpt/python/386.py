
def key_length(cipher):
    max_key_len = 20 # (the length of the key will never be over 20)
 
    max_ = 0
    index_max = 0
    for x in range(1, max_key_len + 1): # Going from 1 to 20
        # Instead of taking sequential substrings, take every nth letter
        pieces = [''.join(cipher[i] for i in range(k, len(cipher), x)) for k in range(x)]
        # calculating the mean value of all the piece in text cut in x pieces
        mean_IC = sum(IC(freq(piece)) for piece in pieces) / len(pieces)
        print(mean_IC, x)
        if mean_IC > max_:
            max_ = mean_IC
            index_max = x
