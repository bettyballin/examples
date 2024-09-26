<?php

$privateKey = '-----BEGIN RSA PRIVATE KEY-----
MIICWwIBAAKBgQCkBLH08f4nZBxiy2K9DXXmxeyqxcZtBIU3BjKDMO0jt2Lt4r6e
+MI/QFKVkms5iDUKaxPgwXptilR/f0KeLz7p2KbsAtDEFSPDWedd2/WYj2DYvoeF
+LskTYoWEyZsTbV7Vcm6lfzlZYggShtjlf6haHHTKo+FEp/ENmspni7n9wIDAQAB
AoGAFrTzshaCeg+ZAnBn1gZ0CSPjlOzWgKc8jhaUjacLXYN49bgLbdTAh6MvC7f+
kjNyLGQQl3ARs/KPqisDHQUrb1mPk2NBlMKk8SPf61D5VPcGyh1OwWSCSM9zg0AO
ZuBhi8RxZhkVAenBwmEAjHID/dA1wGj748uyuUMhq9noGbkCQQDZ/p/2QMGim5dc
KluTxUAtTuxtL5Cjn3rsCNvQiKbDE17zuZQD8O0lKaUIdWpmA9TTVxMXkGiPf/Lf
TApT6lVdAkEAwJ0KXjDsLc6h2lN6LEsm2siAj0fMnCLDUYaRmYB8Wz9S7JGWqE5O
AVg982FeYXxXe2mRL/cpKhbnGT8lvDQpYwJADuUlDPBzyqaS+wsx4rDxp6bi5LsB
SQzWm1YnnuIXcvDZ5hFiGbrWmVl1G1TahknwutgSR+PoIRX/BF7vvbgfSQJAIOYx
8Si2DpTuvFXp1kr31gLNQqvm3PxrFC/CCtARbZyBU3sCmrjVRhGGc128OzZ70s6T
R/gVheTnkD5i+aSHNQJAYGwKSmW7TQPZSlaHfs4vdSnOoxVpdqi/KJG3v+PPhz6R
2+8OZnjXk62VX05jMnMNnu9BMvP0CNjKIjnsOP7NoQ==
-----END RSA PRIVATE KEY-----';

$encryptedKey = 'JJXy5kX9RNSd90BgRSKUX1AGZhwbzetVHKAZTv1/HCBEPGqaGvoWdxaiA8UaJAAr
mS7Sh3pbMm1GN41BYi2r4m9VONknIqn3VB+cikA7ZRxmKOVhRuJTgdjWhrCMyxls
1osAsC8lIFkLo13Z1v8IZAXKGIdyO86WHXzfQku8HAE=';

$encryptedData = 'Y3jrrTI96HVK7aMR/LrLnCGsqlQNvpQN8TTEoClak2GHk1MMV5/Ig6CD5EuojJaIgey7
9XGjf8S9IqLsJ/MxOjODSFM48D+G0lbBW9GEOUFB027pfuHDhyMoTsxjEFBGXIz5';

$decryptedKey = openssl_pkey_get_private($privateKey);
openssl_private_decrypt(base64_decode($encryptedKey), $decryptedKey, $decryptedKey);

$decryptedData = openssl_decrypt(base64_decode($encryptedData), 'RC4', $decryptedKey, OPENSSL_RAW_DATA | OPENSSL_ZERO_PADDING);

printf("Result: %s\n", $decryptedData);

?>