def find_attribute(attr_list, oid):
    for attr in attr_list._attributes:
        if str(attr.oid) == oid:
            return f"{str(attr)} ({attr.value})"

iss = # assuming iss is an object with _attributes, replace with actual object

country = find_attribute(iss, "2.5.4.6")
commonName = find_attribute(iss, "2.5.4.3")

print(f"Country: {country}")
print(f"Common Name: {commonName}")