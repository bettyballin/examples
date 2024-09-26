def display_hex(bytearray):
    return ''.join([f'\\x{b:02X}' if b < 32 or b > 126 else chr(b) for b in bytearray])

# Example usage
data = bytes.fromhex('48656c6c6f')
print(f"Original: {data} -> {display_hex(bytearray(data))}")