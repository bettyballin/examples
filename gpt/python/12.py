
   import tempfile
   import os

   fd, path = tempfile.mkstemp()
   try:
       with os.fdopen(fd, 'w') as tmp:
           # write to `tmp`
           pass
   finally:
       os.remove(path)
   
