let kkey = "your-base64url-encoded-key"; // replace with your key
let kkeyB64 = kkey.replace(/-/g, '+').replace(/_/g, '/'); 
let bkey = sjcl.codec.base64.toBits(kkeyB64);