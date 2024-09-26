
DELIMITER $$

CREATE PROCEDURE GetUserSpecificData(IN user_id VARCHAR(255))
BEGIN
    -- Variable to hold the dynamic SQL
    DECLARE dynamic_query VARCHAR(1000);
    
    -- Start building the dynamic SQL
    SET dynamic_query = 'SELECT ID';
    
    -- Temporary variable to hold the column names
    DECLARE columnName VARCHAR(255);

    -- A cursor to iterate through the column names for the user
    DECLARE columnCursor CURSOR FOR 
        SELECT short
