import os
import tempfile
import zipfile

class YourClass:
    def encrypt(self, filename, key):
        # your encryption logic here
        pass

    def your_method(self, path, directoryname, key):
        with tempfile.TemporaryDirectory() as tmpdirname:
            with zipfile.ZipFile(path, 'w') as my_zip3:
                for folderName, subfolders, filenames in os.walk(directoryname):
                    for filename in filenames:
                        encrypted_filename = self.encrypt(os.path.join(folderName, filename), key)

                        # Write the temporary file to zip
                        my_zip3.write(encrypted_filename, os.path.relpath(encrypted_filename, tmpdirname))

# usage
obj = YourClass()
obj.your_method('path/to/zipfile.zip', 'path/to/directory', 'your_encryption_key')