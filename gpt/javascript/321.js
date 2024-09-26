
const key = sodium.from_hex('827ccb0eea8a706c4c34a16891f84e7b');
const nonce = sodium.randombytes_buf(sodium.crypto_secretbox_NONCEBYTES);

function encrypt(data,
