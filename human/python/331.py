import tkinter as tk

def validateStylist(window):
    # Your validation logic goes here
    print("Finish button clicked")
    window.destroy()

window = tk.Tk()
window.title("Stylist Validation")

finishButton = tk.Button(window, text="Finish",
                      command=lambda: validateStylist(window))

finishButton.pack()
window.mainloop()