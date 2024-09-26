#!/usr/bin/env python3

import getpass
import socket

def main():
    userID = getpass.getuser()
    machineID = socket.gethostname()
    print(f"User ID: {userID}")
    print(f"Machine ID: {machineID}")

if __name__ == "__main__":
    main()