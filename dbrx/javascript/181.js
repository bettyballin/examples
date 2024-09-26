const crypto = require('crypto')

const username = "LoginUser"
const password = "<PASSWORD>"
const nonce = "1234567890"

const LowerCase = s => s.toLowerCase()
const Hex = s => Buffer.from(s, 'utf8').toString('hex')

const SHA1 = s => crypto.createHash('sha1').update(s, 'utf8').digest('hex')
const SHA1Raw = s => crypto.createHash('sha1').update(s, 'utf8').digest()

const SHA256 = s => crypto.createHash('sha256').update(s, 'utf8').digest('hex')
const SHA256Raw = s => crypto.createHash('sha256').update(s, 'utf8').digest()

const UTF8Encode = s => Buffer.from(s, 'utf8');

let step1 = SHA256(UTF8Encode(username))
let step2 = SHA1(UTF8Encode(password))

// Convert hex strings to buffer and then concat
let step3 = SHA256Raw(Buffer.concat([Buffer.from(step1, 'hex'), Buffer.from(step2, 'hex')]))

console.log(`
SHA256(username=${username})                             =     ${step1}
SHA1(password=${password})                               =     ${step2}
SHA256((username  + password)=${username+password})       =     ${step3.toString('hex')}
`)