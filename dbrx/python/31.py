tmp_text = 'example'
block_size = 16

tmp_text = '1' + tmp_text.rjust(block_size // 2 - len(tmp_text), '0') + '1'
print(tmp_text)