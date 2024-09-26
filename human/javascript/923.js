const forge = require('node-forge');

// Generate a private key for demonstration purposes
var privateKey = forge.pki.privateKeyFromPem(`
  -----BEGIN RSA PRIVATE KEY-----
  MIICXAIBAAKBgQCqGKukO1De7zhZj6+H0qtjTkVxwTCpvKe4eCZ0FPqri0cb2JZfXJ/DgYSF6vUp
  wmJG8wVQZKjeGcjDOL5UlsuusFncCzWBQ7RKNUSesmQRMSGkVb1/3j+skZ6UtW+5u09lHNsj6tQ5
  1s1SPrCBkedbNf0Tp0GbMJDyR4e9T04ZZwIDAQABAoGAFijko56+qGyN8M0RVyaRAXz++xTqHBLh
  3tx4VgMtrQ+WEgCjhoTwo23KMBAuJGSYnRmoBZM3lMfTKevIkAidPExvYCdm5dYq3XToLkkLv5L2
  pIIVOFMDG+KESnAFV7l2c+cnzRMW0+b6f8mR1CJzZuxVLL6Q02fvLi55/mbSYxECQQDeAw6fiIQX
  GukBI4eMZZt4nscy2o12KyYner3VpoeE+Np2q+Z3pvAMd/aNzQ/W9WaI+NRfcxUJrmfPwIGm63il
  AkEAxCL5HQb2bQr4ByorcMWm/hEP2MZzROV73yF41hGsDdXeyRmSjA+gjwOpTxW4Wl4iH0kclw4j
  +tRFDuZJS4uk8f/NOBwQwYdQ1fQnUExPjM+P5jH1cR0TQ0T0dV+7+KZc2a9BhQ7WgYb6Rq3mhcG3
  RUwLgFETZMjZg4ETj7UjQKBgF3NqU+bK+w2wDJ5ojHb8n1p1iB+Z6+Yw1bFRMnglDsg8ZtMqQwZ
  X2a1VUjHR4z6qHmuTjxUvJmRhZ6hjRhI4I8L8g6N2NzcsV8q5u+NE3McS2ow/1b3wF4nRwAO6kU
  +VqUp+Z1xwVxMl+zH7tDz7WJFgHQgFpMFxV23JNcA
  -----END RSA PRIVATE KEY-----
`);

var message = 'Hello, World!';
var sha256 = forge.md.sha256.create();
sha256.update(message, 'utf8');
var signature = privateKey.sign(sha256);

var md5 = forge.md.md5.create();
md5.update(signature);

var required_digest = md5.digest().toHex().toUpperCase();
console.log(required_digest);