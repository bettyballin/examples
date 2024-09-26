import ctypes
import usb.core
import usb.util

REG_PATH = r"SYSTEM\CurrentControlSet\Control\StorageDevicePolicies"

# Equivalent of the _IO('U', 20) constant in the linux kernel.
USBDEVFS_RESET = ord('U') << (4 * 2) | 20

def set_reg(name, value):
    try:
        key = ctypes.windll.advapi32.RegCreateKeyW(ctypes.c_uint(0x80000002), REG_PATH, None)
        print("1")
        ctypes.windll.advapi32.RegSetValueExW(key, name, 0, 4, ctypes.byref(ctypes.c_uint(value)))
        ctypes.windll.advapi32.RegCloseKey(key)
        return True
    except Exception as e:
        print(f"oops: {e}")

name = "WriteProtect"
value = 1  # 1 is read only 0 is also writable

x = set_reg(name, value)  # make the usb read only or writable
print(x)

# resetting the usb device
my_device = usb.core.find()
if my_device is not None:
    my_device.reset()  # reset the usb to apply the effect