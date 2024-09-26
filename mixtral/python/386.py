import secrets

def main():
    random_values = [secrets.randbelow(2**32) for _ in range(4)]
    print(''.join([str(value).zfill(10) for value in random_values]))

if __name__ == "__main__":
    main()