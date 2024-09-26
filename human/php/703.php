<?php
include('Crypt/RSA.php');

$privateKey="-----BEGIN RSA PRIVATE KEY-----
MIICXQIBAAKBgQDr5KvAc6JX22BdpsfQbWam8rjkwJzTC954XQzhLOPeGiAGfkPm
CLYhBrmxZN6NxiseivpN9yzrRjYeccr+s3A/8q1EbdhmmM4+AxdNzATEsUxL//MS
VXCaoJhGOfXswokFT8HQod9M6VMmuyDaw9iEorLavV6J/nCmq2HIutcbbwIDAQAB
AoGBAMt2dgnN8zXSW2ELrIcDBapz6rQrylhigWXR5H0IKhb087CGEeyEkQsVcO8o
MKmaRrDWcKT00IKyEZXa0pszjFmD6f90H6TrV6BwZKEynAUVqaX4CCn6x9wgppMA
hWg3eYgoUME3Xgr1Iugb4rqtocEL7Vww/NoUgLXhzHH4RNz5AkEA+mZN2189Te3m
LmXFIJhV+GxrDmYrgJ0csjoEFHAxKJ52lsXTe1VODWbGWAv59jOrbUKe/aQaj4N1
IcTinF3jBQJBAPErTwBKvHznU9dC0eY+JRpwm4Xb9zCNqaG/Ir5N8Gc1U0YLJh9D
vRhtyT9+shwRPznklkc8DKwFaEU7HSiw9uMCQGLK9FLmG6jggN2zd3gpwlmWZRK0
StueoVDMRQnPTgXpp35LJOpXOMle0EiyyPdTYYJlM5d9JKGUyyT8qi/pdwUCQQCE
jp9vs6SCqsukh+/DM+lE7RwuqUbnAxZ39wzruP8oW2EYIMylZqArKzzwj3zqfHha
I9CN+u2kJ5y2YNWYJhytAkA53cDUSL9Wo9pq5hw1C1SWNcimteeQmfQ8f0SMegDW
fZ4rCjGczF82UpB12Cqo8SiK8xrCZAxfnSmSI248oCWe
-----END RSA PRIVATE KEY-----";
$publicKey="-----BEGIN PUBLIC KEY-----
MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDr5KvAc6JX22BdpsfQbWam8rjk
wJzTC954XQzhLOPeGiAGfkPmCLYhBrmxZN6NxiseivpN9yzrRjYeccr+s3A/8q1E
bdhmmM4+AxdNzATEsUxL//MSVXCaoJhGOfXswokFT8HQod9M6VMmuyDaw9iEorLa
vV6J/nCmq2HIutcbbwIDAQAB
-----END PUBLIC KEY-----";

$rsa = new Crypt_RSA();
$rsa->loadKey($publicKey); // public key

$plaintext = 'I am a secret.. shhhhhh.';

$rsa->setEncryptionMode(CRYPT_RSA_ENCRYPTION_PKCS1);
$ciphertext = $rsa->encrypt($plaintext);

$rsa->loadKey($privateKey); // private key
echo $rsa->decrypt($ciphertext);
?>