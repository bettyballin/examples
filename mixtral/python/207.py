import tkinter as tk
import functools

def validateStylist(window):
    # your function code here
    pass

window = tk.Tk()

finishButton = tk.Button(window, text="Finish", command=functools.partial(validateStylist, window))
finishButton.pack()

window.mainloop()