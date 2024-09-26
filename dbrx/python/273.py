import os

def analyze_my_dex_files(my_dex_paths):
    """Analyze individual DEX files."""
    for dex_path in my_dex_paths:
        if not os.path.isfile(dex_path) or not dex_path.endswith('.dex'):
            continue  # Skip non-DEX and invalid paths
        
        print(f"Analyzing {dex_path}...")
        
        # Perform your analysis here using MobSF's existing functions.
        # For demonstration purposes, just print the file size
        print(f"File size: {os.path.getsize(dex_path)} bytes")

# Example usage:
if __name__ == "__main__":
    dex_paths = ["path/to/file1.dex", "path/to/file2.dex"]
    analyze_my_dex_files(dex_paths)