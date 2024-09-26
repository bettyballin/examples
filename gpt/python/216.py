
from passlib.hash import bcrypt
import sqlite3

def create_user(username, password):
    db = sqlite3.connect("test.db")
    c = db.cursor()
    hashed_password = bcrypt.hash(password)
    c.execute("INSERT INTO LOGIN(USER, PASSWORD) VALUES (?, ?)", (username, hashed_password))
    db.commit()
    db.close()

