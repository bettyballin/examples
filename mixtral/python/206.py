import tkinter as tk

def validateStylist(window):
    # Your function implementation here
    pass

window = tk.Tk()
finishButton = tk.Button(window, text="Finish", command=lambda: validateStylist(window))
finishButton.pack()
window.mainloop()