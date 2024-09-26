import shutil

def copy_file():
    try:
        shutil.copy(src="C:/Test/Original.txt", dst="F:/Original.txt")
        print("File copied successfully.")
    except FileNotFoundError:
        print("Source file not found.")
    except PermissionError:
        print("Permission denied. Ensure you have write access to the destination.")
    except Exception as e:
        print(f"An error occurred: {e}")

if __name__ == "__main__":
    copy_file()