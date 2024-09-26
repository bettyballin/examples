def get_attribute(attr):
    return f"{attr.oid}: {attr.value}"

for attr in iss._attributes:
    print(get_attribute(attr))