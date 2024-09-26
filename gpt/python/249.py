
import tkinter as tk
import hashlib
import os
import base64

MEDIUM_FONT = ("Berlin Sans FB", 12)
LARGE_FONT = ("Berlin Sans FB", 16)

# Hash function
def hash_password(password):
    # Create a new salt for this user
    salt = hashlib
