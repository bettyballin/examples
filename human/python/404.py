the_bytes = "öä and ü".encode("utf-8")
the_int = int.from_bytes(the_bytes, 'big')
print(the_int)