def obs_filename(fname):
    string = fname.encode('utf-8').hex()
    return string

# Test the function
print(obs_filename("test_file.txt"))