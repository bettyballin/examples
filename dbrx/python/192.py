xor_result = b'your_bytes_here'  # replace with your actual xor_result
result_bytes = int.from_bytes(xor_result, 'big').to_bytes((len(xor_result) + 7) // 8, 'big')