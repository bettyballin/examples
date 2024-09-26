def main():
    delrv = input("Enter 'K' for encryption or 'D' for decryption: ")
    inm = input("Enter the input message: ")
    splitNyckey = [int(x) for x in input("Enter the key (space-separated integers): ").split()]
    lista = []

    # Encryption
    if delrv.upper() == "K":
        for i in range(len(inm)):
            shifted = ord(inm[i]) + splitNyckey[i % len(splitNyckey)]

            # Handle wrapping around
            if chr(shifted).isalpha():
                shift_range = 26

                # If the character is uppercase
                if inm[i].isupper():
                    shifted %= ord('A') + shift_range

                else:
                    shifted %= ord('a') + shift_range

            lista.append(chr(shifted))

    # Decryption
    elif delrv.upper() == "D":
        for i in range(len(inm)):
            shifted = ord(inm[i]) - splitNyckey[i % len(splitNyckey)]

            # Handle wrapping around
            if chr(shifted).isalpha():
                shift_range = 26

                # If the character is uppercase
                if inm[i].isupper():
                    shifted %= ord('A') + shift_range

                else:
                    shifted %= ord('a') + shift_range

            lista.append(chr(shifted))

    print("".join(lista))

if __name__ == "__main__":
    main()