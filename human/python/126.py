text = ["hello", "world", "example"]
dic = {"hello": "hi", "world": "earth", "example": "sample"}

for i in range(len(text)):
    text[i] = dic[text[i]]

print(text)