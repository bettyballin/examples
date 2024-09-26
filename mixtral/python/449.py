from cryptography.hazmat.primitives import serialization
import subprocess

def get_signature(p7s_file, output):
    # Extract the PKCS#7 signed data using OpenSSL
    cmd = f"openssl pkcs7 -inform DER -out {output} -print_certs < {p7s_file}"

    subprocess.run(cmd, shell=True)

    # Read and parse the output file
    with open(output, "rb") as f:
        content = f.read()

    return content

# Usage
signature = get_signature("signed-data.p7s", "/tmp/extracted-sig.bin")