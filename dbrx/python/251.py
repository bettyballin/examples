import os
import zipfile

class MyClass:
    def encrypt(self, filename, key):
        # Your encryption logic here
        pass

    def zip_and_encrypt(self, directoryname, pathw, key):
        with zipfile.ZipFile(pathw, 'w') as my_zip3:
            for folderName, subfolders, filenames in os.walk(directoryname):
                for filename in filenames:
                    abs_filename = os.path.abspath(os.path.join(folderName, filename))
                    print(abs_filename)  # Print the absolute path instead

                    self.encrypt(abs_filename, key)

                    if not os.path.exists(abs_filename):  # Check that file still exists
                        raise RuntimeError(f"File '{abs_filename}' was deleted after encryption")

                    my_zip3.write(abs_filename)

# Usage
obj = MyClass()
obj.zip_and_encrypt('/path/to/directory', '/path/to/zipfile.zip', 'your_key')