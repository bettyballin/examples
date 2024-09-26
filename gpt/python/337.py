
import win32crypt

# Open the "MY" certificate store (which is the Personal store)
store = win32crypt.CertOpenStore(win32crypt.CERT_STORE_PROV_SYSTEM, 0, None, win32crypt.CERT_SYSTEM_STORE_CURRENT_USER, "MY")

# Find the certificate by its common name (or use other search criteria)
