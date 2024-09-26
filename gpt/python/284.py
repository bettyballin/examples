
import tkinter
from cryptography.fernet import Fernet

class Cryptography:

    def __init__(self):
        self.key = Fernet.generate_key()
        self.f = Fernet(self
