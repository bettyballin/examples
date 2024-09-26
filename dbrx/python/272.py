import glob

def get_dex_files(app_dir):
    """Get all Dex Files for analysis."""
    glob_pattern = app_dir + '/*.dex'
    return glob.glob(glob_pattern)

# Example usage:
app_dir = '/path/to/app/directory'
dex_files = get_dex_files(app_dir)
print(dex_files)