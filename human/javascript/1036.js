const crypto = require('crypto');

function genkey(serial, seed, date, type) {
    const fullstring = serial + seed + date + type;
    const md5 = crypto.createHash('md5').update(fullstring).digest('hex');
    const encrypted = encryptDecrypt('encrypt', md5);
    return condense(condense(encrypted));
}

function encryptDecrypt(action, string) {
    const secretKey = '[REDACTED]'; //32 byte
    const secretIv = '[REDACTED]'; //16 byte
    const key = crypto.createHash('sha256').update(secretKey).digest();
    const iv = crypto.createHash('sha256').update(secretIv).digest().slice(0, 16);

    let output;
    if (action === 'encrypt') {
        const cipher = crypto.createCipheriv('aes-256-cbc', key, iv);
        output = Buffer.concat([cipher.update(string, 'utf8'), cipher.final()]).toString('base64');
    } else if (action === 'decrypt') {
        const decipher = crypto.createDecipheriv('aes-256-cbc', key, iv);
        output = decipher.update(string, 'base64', 'utf8') + decipher.final('utf8');
    }
    return output;
}

function condense(str) {
    const arr = str.match(/.{1,3}/g);
    let retstr = '';
    for (let i = 0; i < arr.length; i++) {
        const sum = wordSum(arr[i]);
        const letternum = sum % 26 + 65; //ascii code for capital letter
        const letter = String.fromCharCode(letternum);
        retstr += letter;
    }
    return retstr;
}

function wordSum(str) {
    let sum = 0;
    for (let i = 0; i < str.length; i++) {
        sum += str.charCodeAt(i);
    }
    return sum;
}