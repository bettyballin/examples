from charm.toolbox.pairinggroup import PairingGroup

# Initialize a pairing group with SS512 curve
group = PairingGroup('SS512')

# Encode "Hello world!" as an integer and convert it to bytes
message_bytes = str.encode("Hello world!")

# Convert the message into an element from GT group using encode method
msg = group.decode(group.encode(message_bytes))

print(f"Encoded Message: {msg}")