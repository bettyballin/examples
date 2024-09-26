Here is the corrected code:


def cipher(s, key):
    down = True
    raw_out = [''] * len(s)
    i = 0
    pos = 0
    index = 0
    
    while pos < len(s):
        if not down:
            # Move upwards by decrementing index variable `i`
            for j in range(i - (key // 2) - (key % 2)):
                if index < len(s):
                    raw_out[i] += s[index]
                    index += 1
                i -= 1
            down = True
        else: 
            # Move downwards by incrementing index variable `i` until it reaches the middle of rail fence cipher.
            for j in range(i + (key // 2) + (key % 2)):
                if index < len(s):
                    raw_out[i] += s[index]
                    index += 1
                i += 1
            down = False
        pos += 1
        
    return ''.join(raw_out)

def decipher(s, key):
    map_list = list(cipher(s, key))
    new = [''] * len(map_list)
    index = 0
    
    for p in range(len(new)):
        if (p + int(key / 2)) % key == 0:
            down = False
        elif (p - int(key / 2) + 1) % key == 0: 
            down = True
        if index < len(map_list):
            new[p] += map_list[index]
            index += 1

    return ''.join(new)

s = "Hello, World!"
key = 3
encrypted = cipher(s, key)
print("Encrypted:", encrypted)
decrypted = decipher(s, key)
print("Decrypted:", decrypted)