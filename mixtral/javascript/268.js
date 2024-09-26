const crypto = require('crypto')

const username = "LoginUser"
const password = "LoginPass"

const Hex = s => Buffer.from(s, 'utf8').toString('hex');

const SHA1Raw = s => crypto.createHash('sha1').update(Buffer.from(s)).digest();

const SHA256Raw = s => crypto.createHash('sha256').update(Buffer.from(s)).digest()

let step1 = Hex(SHA256Raw(username))
let step2 = Hex(SHA1Raw(password));

const bufStep1 = Buffer.from(step1, 'hex')
const bufStep2 = Buffer.from(step2, 'hex');

let step3 = SHA256Raw(Buffer.concat([bufStep1, bufStep2]))

console.log(`
SHA256(username=${username})                             =     ${Hex(step1)}
SHA1(password=${password})                               =     ${Hex(step2)}
SHA256(SHA256(username) + SHA1(password))                =     ${Hex(step3)}
`)