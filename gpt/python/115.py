
def cryptofied(text, dic):
    ret = ""
    for p in range(len(text)):
        # Use the get method with the original character as the default value.
        ret += dic.get(text[p].upper(), text[p])
    return ret

# Your encode function seems fine, just remember that it will work
# only with uppercase letters unless you modify the `lock` dictionary
# to include lowercase letters as well.

