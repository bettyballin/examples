import itertools

def Encrypt(plainText, key):  
    keyA = 0    
    for letter in key:
        keyA ^= letter  
    keyA = keyA & 0xFF 
    key = itertools.cycle(key) 
    codedText = ""
    for letter,keyCode in zip(plainText,key):
         xorVal = (keyCode * keyA) & 0xFF 
         newLetter = chr((ord(letter) ^ xorVal )&0xFF) 

         codedText += newLetter
         keyA += ord(newLetter)
         keyA = keyA&0xFF 

    return codedText

# example usage:
plainText = "Hello, World!"
key = [0x12, 0x34, 0x56, 0x78, 0x90, 0xab, 0xcd, 0xef, 0x12, 0x34, 0x56, 0x78, 0x90, 0xab, 0xcd, 0xef, 0x12, 0x34, 0x56, 0x78]
print(Encrypt(plainText, key))