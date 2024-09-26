def decrypt(number):
    code = {
        "123": "a",
        "234": "b",
        "345": "c",
        # Add more mappings as needed
    }

    # Split the input into groups of 3 characters
    chunks = [number[i:i+3] for i in range(0, len(number), 3)]

    decryption = ""

    for chunk in chunks:
        if chunk.strip() != '':
            # Remove any trailing spaces before looking up the dictionary
            code_key = chunk.rstrip(' ')

            try:
                decryption += code[code_key]

            except KeyError as e:
                print(f"Invalid character found in input: {e}")

    return decryption