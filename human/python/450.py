from Crypto.Hash import MD4

def main():
    psk = 'The quick brown fox jumps over the lazy dog'
    h = MD4.new()
    h.update(psk.encode('UTF-8'))
    print(f'UTF8:     {h.hexdigest()}')

if __name__ == "__main__":
    main()