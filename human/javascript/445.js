const forge = require('node-forge');
const CryptoJS = require('crypto-js');

var private_key = `-----BEGIN RSA PRIVATE KEY-----
MIIEpAIBAAKCAQEAx1u1OPc+KT1vmLea4ro0VtdiQa9Pj7oFMF04uIPKb5BEuN6w
rHj3dQkdoeT3vWZaR/eAOnxSIgl4PwNm9C6AeW5vHAq/4XFp4FZbtbHfqCm3h6tT
m8FxmuTZQVr+Kgrkgiob/C5+bWHhD+rfUnaW8CGnvmhHD4AtxCVimMUhYLCSklkX
YOWng9aRO5kAvDx0KXyZ60YsJJwUouPat/vBdoHljRZhzOb7KHSek4yd//0zBmBW
3y9z+KG8WrpGEoCutGE14QBGh/EghRP9QAhfGV4a9kfD77S0Spu7uzmfzBuyyit5
Dhtcact4SJuJz2617I1gujGe51j5Oyex70hoEQIDAQABAoIBACJl5IMLxiH/g73q
EEOGtXk2eLG0uhmmkzahHyRXORq+3dy4L+vSg4AiLoa8pzJ68qDwR6PPx6wvzhux
TpZbX7eUIn/IKwuPMiGPRQu4wUqWyCAUo7yASEXdrs7kEG7Yqkz7TxDYROBCvz6r
3BSyeaC9beAgxgIar8rkWHrbqMKx5koX+3nopn2vrEQWTsP5PebMnC/2u3k3BfIW
5ucgaYlbrzfYULx2DZdBEuBtourE0yQePxNvTDd6tjcSnH/G/pZdy9GXamvgbIRH
5YCzO9gaiEzRgbddX96AHNXK7LmmSOvX4mdzjmkNb4yKud8+/fpX9fa4sIzKBMuB
15rdfzECgYEA/58+QBu2rjmE5qA6uMQYtzF7AvLK2ZfhfBs6lt/ItnlQ283sKaHS
vkzjmvVVq7hjbvjvFJ6aUAwzZ9XhOjbdpvkwVhGZfNdx7ia6ctH9q0Cq8ksmhVbD
SSEklWK5k5OcXbd8DiVClX8hRR13WbhK+L9Ct4/4+/2kA9bnsJKi92cCgYEAx6cr
A8faHUdIHSo01S8bRijCOVLKNXuOsgqVxe05RrcqJI/QpaHTFPvVm1rUb97sq9pW
eQANrWoONmoGVWzmKzK3Hk6mLSKfbPEhclQgVTsrlp4Mil9e06pqqw6FmuxFrk/5
FCws84vyijzt4/qvh1tXJoX7+xSSa82v86wJ0ccCgYEA0FhSvJ3Z/5cSI4dlVUM/
gdDqmjSZ8VBBkI4A6wfq6A9pQD5OxoAG7ORuftaHxTa8lK6A7yV2UNgg7fj9Yh1l
+7oPE5e0qnRPf/RA82UEhJhovKNT+koFUY2Z68hTyVz+jcQHcOAdrQu5akPiC1aS
hLwe/M5z+a96B0caAGkEOvECgYEAkOM3zB6Uovq/0qp2fN8ao+egS4lRRU7NV1dn
KaPmFPOHmdDkUc8GKAw6D+vyjtzwVCa26kinpFl6xvJadlP5FRBQ46Wf4tFlcOHs
q9NxQ2kVUNCRuTlMz760ej6npq4gQ0e2MnV8iaHd+YQN/4xFJa2bqVFCdAuR1roG
HoeS+LECgYAsJhCTNQUCeqvXO2cdJTQ1da3ug/P3c0Eg5DyrB7w7Fwtq/eeSsZOf
R1et6S+aRaEfclx2vEF9Ck4hcTESRNZrZJ4i5hB4y//B1og777H/jrT7H1NZfU11
Iwly+S/SlgTR9BrXCJsfenslolp/rMgiD2G8sky5yFRmrDB7qj8/Nw==
-----END RSA PRIVATE KEY-----`;

var encrypted = 'E+moZJOeVuxgsg=='; 
var envelope = 'LMJqdAu+FVPxVpVkLgBOrqLWkY/S/56KHETnt528k2D0lUDzl7nymsgycrto5BD4w17oH6THyC+0yg/Ws+gqpIIWimcQze1KKQy+1+uvH4gR1Olt22cgEUDid09dDqvSXi0VcYYYQXyxWzIQVd2Jun1A0h1qhWc4LinzkJSP6HuhH+D52eEcXep5H4cjjy62rgGIR5YyQO/RBXuYYBBRSgmeniFjY9FbR8AaBkhcCVYeBH28uBi0dx27hPQ0yVlVWrG3KuR2i441Ruhb4J+AOnr+K1uIMT+rnk8Th8eTTc/E1CSrZo9GASfEyYK8mJdwfq2/FJ5Qnp9uHl1aN/1RSg==';

var privateKey = forge.pki.privateKeyFromPem(private_key);
var theKey = privateKey.decrypt(forge.util.decode64(envelope), 'RSAES-PKCS1-V1_5');

var decrypted = CryptoJS.RC4.decrypt({
    ciphertext: CryptoJS.enc.Base64.parse(encrypted)
}, CryptoJS.enc.Latin1.parse(theKey));
console.log(decrypted.toString(CryptoJS.enc.Utf8));