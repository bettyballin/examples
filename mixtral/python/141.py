import os
import sys

def process():
    # Read data from pipe

    while True:
        try:
            line = sys.stdin.readline().strip()

            if not line or 'END' in line:
                break
        except Exception as e:
            print(f"An error occurred: {e}")
            break

if __name__ == "__main__":
    process()