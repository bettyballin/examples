import bcrypt
from tkinter import *
from tkinter import messagebox

w = Tk()
w.title("Login")

l1 = Label(w, text="Username")
l1.pack()
e1 = Entry(w)
e1.pack()

l2 = Label(w, text="Password")
l2.pack()
e2 = Entry(w, show="*")
e2.pack()

def login():
    x = e1.get()
    y = e2.get().encode('utf-8')  # Convert password to bytes

    hashed_password = b'$2b$12$mY/KoUjZqwXyvJGdRiQB0OeDlzr3hT4s7k.LNW6n5M8fV9FpEgxHu'  # Replace with the actual hashed password

    if x == 'hamed':
        if bcrypt.checkpw(y, hashed_password):
            messagebox.showinfo(title='Login', message='Login successful')
            w.destroy()
        else:
            messagebox.showerror('Error', 'Username or password is wrong!')
    else:
         messagebox.showerror('Error', 'username or password is wrong!')

b = Button(w, text="Login", command=login)
b.pack()

w.mainloop()