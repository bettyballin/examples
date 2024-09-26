def pad_hex_string(hex_string, length):
    while len(hex_string) < length:
        hex_string = "0" + hex_string
    return hex_string

def main():
    hex_string = "123abc"
    length = 8
    padded_hex_string = pad_hex_string(hex_string, length)
    print(f"Original Hex String: {hex_string}")
    print(f"Padded Hex String: {padded_hex_string}")

if __name__ == "__main__":
    main()