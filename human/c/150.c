This is not C code, it's Python code. Here is the corrected version:

python
import base58
import hashlib

def check_wif(wif):
    """WIF checksum checking.
    Install base58 before use: `pip install base58`

    >>> check_wif('5HueCGU8rMjxEXxiPuD5BDku4MkFqeZyd4dZ1jvhTVqvbTLvyTJ')
    True
    """
    try:
        wif_bytes = base58.b58decode(wif)
        if wif_bytes[0] != 128:
            return False
        wif_bytes_no_chksum, chksum = wif_bytes[:-4], wif_bytes[-4:]
        wif_bytes_sha256_1 = hashlib.sha256(wif_bytes_no_chksum)
        wif_bytes_sha256_2 = hashlib.sha256(wif_bytes_sha256_1.digest())
        if wif_bytes_sha256_2.digest()[:4] == chksum:
            return True
        else:
            return False
    except ValueError:
        return False

# Make the script executable
if __name__ == "__main__":
    import sys
    if len(sys.argv) != 2:
        print("Usage: python script.py <WIF>")
        sys.exit(1)

    wif = sys.argv[1]
    result = check_wif(wif)
    print(result)