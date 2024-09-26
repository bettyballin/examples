
-- Generate a cryptographically secure random integer
SELECT CAST(CRYPT_GEN_RANDOM(8) AS BIGINT) AS SecureRandomInteger;

