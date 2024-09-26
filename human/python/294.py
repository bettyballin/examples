import ssl

class SSLContext:
    def __init__(self, certfile, keyfile):
        self.certfile = certfile
        self.keyfile = keyfile

    def load_context(self):
        context = ssl.create_default_context()
        context.load_cert_chain(certfile=self.certfile, keyfile=self.keyfile, password=b"passphrase")
        return context

# example usage:
ssl_context = SSLContext("path/to/certfile.crt", "path/to/keyfile.key")
context = ssl_context.load_context()