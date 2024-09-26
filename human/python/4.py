import os, tempfile

tmpdir = tempfile.mkdtemp()
filename = os.path.join(tmpdir, 'myfifo')
print(filename)
try:
    os.mkfifo(filename)
except OSError as e:
    print("Failed to create FIFO: %s" % e)
else:
    with open(filename, 'w') as fifo:
        print("hello", file=fifo)
    os.remove(filename)
    os.rmdir(tmpdir)