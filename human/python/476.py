import subprocess
import sys

def install_cryptography():
    try:
        subprocess.check_call([sys.executable, "-m", "pip", "install", "cryptography"])
    except subprocess.CalledProcessError as e:
        print(f"Error installing cryptography: {e}")

if __name__ == "__main__":
    install_cryptography()