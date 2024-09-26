def crypto_fied(text, dic):
    ret = ""
    for char in text:
        if char in dic:
            ret += dic[char]
        else:
            # Ignore unknown characters
            continue

    return ret

# Test the function
lock = {'A':'X', 'B':'P', 'C':'O', 'D':'N', 'E':'M', 'F':'L', 'G':'K', 'H':'J', 'I':'I', 'J':'H', 'K':'G', 'L':'F', 'M':'E', 'N':'D', 'O':'C', 'P':'B', 'Q':'A', 'R':'Z', 'S':'Y', 'T':'X', 'U':'W', 'V':'V', 'W':'U', 'X':'T', 'Y':'S', 'Z':'R'}
code_msg = "frank"
encoded_message = crypto_fied(code_msg.upper(), lock)
print("Encoded message:", encoded_message)