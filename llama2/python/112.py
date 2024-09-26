import sys

def check_user():
    # check user against target fingerprint
    a = True  # Define 'a' variable
    if a is True:
        try:
            import x
        except ImportError:
            print("Error: module 'x' not found")
            sys.exit(1)
        # do something with x
        print(x)

if __name__ == "__main__":
    check_user()