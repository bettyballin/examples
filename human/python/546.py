import io
from tink import aead
from tink import tink_config
from tink import JsonKeysetWriter
from tink import new_keyset_handle
from tink import cleartext_keyset_handle

tink_config.register()

key_template = aead.aead_key_templates.AES256_GCM
keyset_handle = new_keyset_handle(key_template)

string_out = io.StringIO()
writer = JsonKeysetWriter(string_out)
cleartext_keyset_handle.write(writer, keyset_handle)

serialized_keyset = string_out.getvalue()
print(serialized_keyset)