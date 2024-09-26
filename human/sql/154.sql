#standardSQL 
SELECT address, eth_balance 
FROM `bigquery-public-data.crypto_ethereum.balances` 
WHERE address = LOWER('0x5245A7C4Cac42f20FC352491c4b7127c5bf30A44');