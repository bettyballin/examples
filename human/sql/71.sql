-- Create a test table with a sensitive column
CREATE TABLE SomeTable (
  id INT AUTO_INCREMENT,
  sensitive_column VARCHAR(255),
  PRIMARY KEY (id)
);

-- Insert some test data
INSERT INTO SomeTable (sensitive_column)
VALUES ('secret data 1'), ('secret data 2'), ('secret data 3');

-- Update the sensitive column with encrypted data
UPDATE SomeTable
SET sensitive_column = AES_ENCRYPT(sensitive_column, UNHEX('password'));

-- To verify the encryption, select the data
SELECT id, AES_DECRYPT(sensitive_column, UNHEX('password')) AS decrypted_data
FROM SomeTable;

-- Cleanup
DROP TABLE SomeTable;