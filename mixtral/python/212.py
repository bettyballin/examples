import win32con
from win32 import win32api, win32print

# Add some executable code here
def main():
    printers = win32print.EnumPrinters(5)
    for p in printers:
        print(p[2])

if __name__ == "__main__":
    main()