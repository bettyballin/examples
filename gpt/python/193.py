
   import socket

   server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
   server_socket.bind(('localhost', 50000))
   server_socket.listen(1)
   connection, client_address = server_socket.accept()

   try:
       while True:
          
