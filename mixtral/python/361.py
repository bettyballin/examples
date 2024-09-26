import glob

def find_dex_files(ddex_dir):
    glob_pattern = ddex_dir + '/*.dex'
    return glob.glob(glob_pattern)

# Example usage:
ddex_dir = '/path/to/dex/files'
dex_files = find_dex_files(ddex_dir)
print(dex_files)