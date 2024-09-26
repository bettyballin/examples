import shutil
import getpass

# specify source (file on your computer)
source = "/path/to/your/Original.txt"

# specify destination (USB stick path + filename e.g Copied.txt)
username = getpass.getuser()
usb_stick_label = "Your USB Stick Label"
destination = "/media/{username}/{usb_stick_label}/Copied.txt".format(
    username=username,
    usb_stick_label=usb_stick_label
)

# copy the file
shutil.copy2(source, destination)