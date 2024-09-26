
def Encrypt(plainText, key): # plainText is a list of integers representing ascii 
                             # characters, key is a list of int size 20 each int 
                             # between 0 and 255
    keyA = 0
    codedText = [0] * len(plainText)  # Initialize codedText list with the same length as plainText

    for n in range(20):
        keyA ^= key[n]

    nKeyPos = keyA % 20

    for n in range(len(plainText)):
        #
