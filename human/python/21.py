from io import StringIO
import gnupg
import logging
import os
import shutil

def generate_key(gpg, first_name, last_name, domain, passphrase=None):
    "Generate a key"
    params = {
        'Key-Type': 'DSA',
        'Key-Length': 1024,
        'Subkey-Type': 'ELG-E',
        'Subkey-Length': 2048,
        'Name-Comment': 'A test user',
        'Expire-Date': 0,
    }
    params['Name-Real'] = '%s %s' % (first_name, last_name)
    params['Name-Email'] = ("%s.%s@%s" % (first_name, last_name, domain)).lower()
    if passphrase is None:
        passphrase = ("%s%s" % (first_name[0], last_name)).lower()
    params['Passphrase'] = passphrase
    cmd = gpg.gen_key_input(**params)
    return gpg.gen_key(cmd)

def init_logging():
    logging.basicConfig(level=logging.DEBUG, filename="gpg.log",
                        filemode="w", format="%(asctime)s %(levelname)-5s %(name)-10s %(threadName)-10s %(message)s")

def print_info(decrypted):
    print('User name: %s' % decrypted.username)
    print('Key id: %s' % decrypted.key_id)
    print('Signature id: %s' % decrypted.signature_id)
    #print('Signature timestamp: %s' % decrypted.sig_timestamp)
    print('Fingerprint: %s' % decrypted.fingerprint)

def main():
    init_logging()
    if os.path.exists('keys'):
        shutil.rmtree('keys')
    gpg = gnupg.GPG(gnupghome='keys')
    key = generate_key(gpg, "Andrew", "Able", "alpha.com",
                            passphrase="andy")
    andrew = key.fingerprint
    key = generate_key(gpg, "Barbara", "Brown", "beta.com")
    barbara = key.fingerprint
    #First - without signing
    data = 'Top secret'
    encrypted = gpg.encrypt_file(StringIO(data), barbara,
                                 #sign=andrew, passphrase='andy',
                                 output='encrypted.txt')
    assert encrypted.status == 'encryption ok'
    # Data is in encrypted.txt. Read it in and verify/decrypt it.
    data = open('encrypted.txt', 'r').read()
    decrypted = gpg.decrypt(data, passphrase='bbrown', output='decrypted.txt')
    print_info(decrypted)
    #Now with signing
    data = 'Top secret'
    encrypted = gpg.encrypt_file(StringIO(data), barbara,
                                 sign=andrew, passphrase='andy',
                                 output='encrypted.txt')
    assert encrypted.status == 'encryption ok'
    # Data is in encrypted.txt. Read it in and verify/decrypt it.
    data = open('encrypted.txt', 'r').read()
    decrypted = gpg.decrypt(data, passphrase='bbrown', output='decrypted.txt')
    print_info(decrypted)

if __name__ == '__main__':
    main()

Note: I replaced `from cStringIO import StringIO` with `from io import StringIO` because `cStringIO` is not available in Python 3.x. Also, make sure you have the `gnupg` library installed. You can install it using pip: `pip install python-gnupg`.