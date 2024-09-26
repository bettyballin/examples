def pad(block, block_size):
    return '0' * (block_size - len(block)) + block

def encrypt_block(block):
    # your encryption logic here
    return block

data = "10101010"  # example data
text_size = 8  # example block size
block_size = 8  # example block size
encrypted_message = ""
tmp_text = ""

for i in data:
    if len(tmp_text) == text_size or i == data[-1]:  # when a block is complete
        tmp_text = encrypt_block('1' + pad(tmp_text, block_size))
        encrypted_message += tmp_text
        tmp_text = ""
    if i == '0' or i == '1':
        tmp_text += i

print(encrypted_message)