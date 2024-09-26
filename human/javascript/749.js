const b64binb = base64String => Uint8Array.from(atob(base64String), c => c.charCodeAt(0));
const str2binb = str => new TextEncoder().encode(str);
const buf2hex = buffer => Array.prototype.map.call(new Uint8Array(buffer), x => ('00' + x.toString(16)).slice(-2)).join('');

async function pbkdf2_generate_key_from_string(string) { 
    return crypto.subtle.importKey(
        "raw",
        str2binb(string),
        {
            name: "PBKDF2",
        },
        false,
        ["deriveKey", "deriveBits"], 
    );
}

async function pbkdf2_derive_salted_key(key, salt, iterations) {  
    return crypto.subtle.deriveKey(
        {
            name: "PBKDF2",
            salt: salt,
            iterations: iterations,
            hash: {name: "SHA-1"}
        },
        key,
        {
            name: "HMAC",
            hash: "SHA-1",
            length: 160
        },
        true,
        ["sign", "verify"]
    );
}

async function test(){
    let salt = b64binb("QSXCR+Q6sek8bf92"); 
    let key = await pbkdf2_generate_key_from_string("pencil");
    let x = await pbkdf2_derive_salted_key(key, salt, 4096)

    console.log(buf2hex(await window.crypto.subtle.exportKey("raw", x)));
}

test();