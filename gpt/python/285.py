
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives.hashes import Hash, MD5

def _pbkdf1_md5(a_password, a_salt, a_iterations):
    digest = Hash(MD
