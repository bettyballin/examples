import subprocess

subprocess.run([
    "openssl", 
    "enc", 
    "-aes-128-ecb", 
    "-nosalt", 
    "-nopad", 
    "-K", 
    "79656c6c6f77207375626d6172696e65", 
    "-in", 
    "plain.txt", 
    "-out", 
    "cipher.txt", 
    "-a"
])