import codecs

def deobs_filename(fname):
    string = codecs.decode(fname, "hex")
    new_file_name = str(string, 'utf-8')
    return new_file_name

# Example usage:
filename = "48656c6c6f2e747874"
print(deobs_filename(filename))