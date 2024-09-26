
CREATE PROCEDURE DNB_ENCRYPT
(   
    @Value NVARCHAR(MAX),
    @EncryptedValue VARBINARY(MAX) OUTPUT -- Use VARBINARY(MAX) for encrypted data
)    
AS
BEGIN
    -- (
