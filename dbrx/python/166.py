Key = b"your_key_here"

with open("Keys.bin", "wb") as f:
    f.write(Key)

# Later to read it back...
with open("Keys.bin", "rb") as f:
    Key = f.read()

print(Key)