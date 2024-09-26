
from Crypto.Hash import MD4

psk = 'The quick brown fox jumps over the lazy dog'

# Correct usage for UTF-8 encoding
h = MD4.new(data=psk.encode('
