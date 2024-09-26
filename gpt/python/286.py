
if (not ((asciiValue >= 65 and asciiValue <= 90) \
   or (asciiValue >= 97 and asciiValue <= 122) \
   or (asciiValue == 32))):
   # if the character is not one of the characters ("A-Z" or "a-z"
   # or " ") consider it as an "error"
   errorChar += 1

