CREATE TABLE eth_balances (
  address VARCHAR(42),
  eth_balance BIGINT
);

INSERT INTO eth_balances (address, eth_balance)
VALUES ('0x5245a7c4cac42f20fc352491c4b7127c5bf30a44', 23743356716445772);

SELECT * FROM eth_balances;