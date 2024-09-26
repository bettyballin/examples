const req = { nonce: 'your_nonce_value' };
const postdata = 'your_postdata_value';

const message = encodeURIComponent(req['nonce'] + postdata);
console.log(message);