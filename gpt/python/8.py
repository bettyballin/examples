
import os
import errno
import tempfile

def create_temp_fifo():
    temp_dir = tempfile.mkdtemp()
    fifo_name = os.path.join(temp_dir, "temp_fifo")

    try:
        os.mkfifo(fifo_name)
    except OSError as e:
        if e.errno != errno.EEXIST:
            raise
    return fifo_name

# Usage
temp_fifo = create_temp_fifo()
print("FIFO created at:", temp_fifo)

# To write to FIFO you can do this in a separate process or thread
with open(temp_fifo, 'w') as fifo_writer:
    fifo_writer.write("This will be read by the reader")

# To read from FIFO, typically in another process or thread
with open(temp_fifo, 'r') as fifo_reader:
    data = fifo_reader.read()
    print(data)

# Clean up the FIFO and temporary directory when done
os.remove(temp_fifo)
os.rmdir(os.path.dirname(temp_fifo))
``
