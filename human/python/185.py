import hashlib, base64

print(base64.b85encode(hashlib.sha256(b"hello world").digest()).decode('utf-8'))
# output: xlJdzlTAJdr7lv}+I_3~#DwqTdQ*VzkcjuJ;_uDr