const ECIES = require('bitcore/lib/ECIES');

const onetime_public_key = 'your_onetime_public_key_here';
const d_receiver_hex = 'your_receiver_private_key_here';

const ot_pubkey = Buffer.from(onetime_public_key, 'hex');
const my_privkey = Buffer.from(d_receiver_hex, 'hex');

const ecies = new ECIES.encryptObj(ot_pubkey, Buffer.from(''), my_privkey);
const S = ecies.getSfromPubkey();
console.log('bitcore sharedsecret\t', S.toString('hex'));

const S_kdf_buf = ECIES.kdf(S);
console.log('bitcore sharedsecret kdf\t', S_kdf_buf.toString('hex'));