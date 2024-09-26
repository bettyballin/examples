import rsa

def main():
    (pubkey, privkey) = rsa.newkeys(512) # 512 only for testing purposes, otherwise at least 2048

    # PEM (default)
    print(privkey.save_pkcs1().decode('utf-8'))
    print(pubkey.save_pkcs1().decode('utf-8'))

    # DER
    print(privkey.save_pkcs1('DER').hex())
    print(pubkey.save_pkcs1('DER').hex())

if __name__ == "__main__":
    main()