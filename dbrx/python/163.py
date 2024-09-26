import shutil

# Open original file in read mode
with open("Original.txt", "r") as Original:
    # Copy the content of 'Original.txt'
    Content = Original.read()

# Save copied content to USB drive (assuming it's mounted at '/mnt/usb')
USB_path = "/mnt/usb/Copied.txt"
with open(USB_path, "w") as Copied:
    Copied.write(Content)