def breakSingleByteXOR(cipherString):
    alphabet = "abcdefghijklmnopqrstuvwxyz"
    lowestError = 1.0
    for i in range(256):
        tempMess = ""
        errorChar = 0.0
        for j in range(0, len(cipherString), 2):
            byte = cipherString[j:j+2]
            xoredByte = hex(int(byte, 16) ^ i)[2:].zfill(2)
            tempMess += xoredByte
            if chr(int(xoredByte, 16)).lower() not in alphabet and not chr(int(xoredByte, 16)).isspace():
                errorChar += 1.0
        errorChar /= len(cipherString) / 2
        if errorChar < lowestError:
            lowestError = errorChar
            decryptedMess_bytes = bytes.fromhex(tempMess)  
            realKey = chr(i)
            return realKey, decryptedMess_bytes.decode()   

if __name__ == "__main__":
    key, message = breakSingleByteXOR("1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736")
    print(f"Key: {key}\nMessage: {message}")