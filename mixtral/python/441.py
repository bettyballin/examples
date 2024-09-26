import os
from tkinter import *
import sqlite3
from sqlcipher3 import dbapi2 as sqlcipher

def create_window():
    window = Tk()
    window.title("My Window")
    window.geometry("400x200")
    label = Label(window, text="Hello, World!")
    label.pack()
    window.mainloop()

def create_database():
    conn = sqlcipher.connect('my_database.db')
    c = conn.cursor()
    c.execute('''CREATE TABLE IF NOT EXISTS users
                 (id INTEGER PRIMARY KEY, name TEXT)''')
    conn.commit()
    conn.close()

def main():
    create_database()
    create_window()

if __name__ == "__main__":
    main()