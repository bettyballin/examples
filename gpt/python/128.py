
def decoded(s):
    for i in range(95):
        string = ""
        for char in s:
            if char.isprintable():
                shifted = ord(char) - i
                if shifted < 32:
                    shifted += 95  # 95 is the number of printable ASCII characters (126 - 32 + 1)
                string += chr(shifted)
            else:
                string += char  # Non-printable characters are not shifted
        print(f"Shift {i}: {string}")

encoded_text = "T! x$r&'}
