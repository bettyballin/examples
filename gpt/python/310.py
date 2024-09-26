
def string_to_octets(input_string):
    # Encode the input string into bytes using utf-8 encoding
    octet_string = input_string.encode('utf-8')
    return octet_string

# Example usage:
input_string = "Men of few words are the best men."
octet_string = string_to_octets(input_string)
print(octet_string)

# If you want to see the individual octet values
octet_values = list(octet_string)
print(octet_values)

