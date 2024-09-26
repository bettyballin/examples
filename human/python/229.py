counter_iv = 112
iv_bytes = bytes(((counter_iv >> (i * 8)) & 0xFF) for i in range(16))