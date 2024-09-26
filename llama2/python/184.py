import glob

def encrypt_file(file):
    # Your encryption logic here
    pass

if __name__ == "__main__":
    for file in glob.glob('**/*', recursive=True):
        encrypt_file(file)