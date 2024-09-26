import subprocess

subprocess.run([
    "openssl", "enc", "-e", "-aes-128-cfb",
    "-in", "plain.txt",
    "-out", "encrypted.txt",
    "-K", "3398699acebda0dab39a46f5cc4f0d45",
    "-iv", "b39a46f5cc4f0d45b39a46f5cc4f0d45"
])