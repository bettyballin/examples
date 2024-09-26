const nonce1 = 'nonce-value-1';
const nonce2 = 'nonce-value-2';

const csp = `Content-Security-Policy: script-src  'nonce-${nonce1}' 'nonce-${nonce2}'`;

console.log(csp);