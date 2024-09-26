
   # In foo1.pyw
   import os
   fifo_path = "/tmp/my_secure_fifo"
   os.mkfifo(fifo_path)
   with open(fifo_path, 'w') as fifo:
       fifo.write('sensitive information')

   # In foo2.py
   fifo_path = "/tmp/my_secure_fifo"
   with open(fifo_path, 'r') as fifo:
       data = fifo.read()
   
