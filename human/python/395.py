import win32security

def main():
    print([name for name in dir(win32security) if callable(getattr(win32security, name))])

if __name__ == "__main__":
    main()