import codecs
plain = "Hello World"
cipher = codecs.encode(plain, "rot_13")
print(cipher)  # Uryyb Jbeyq
againplain = codecs.decode(cipher, "rot_13")
print(againplain)  # Hello World