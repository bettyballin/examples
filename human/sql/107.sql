SET @groepsindeling = IFNULL(@id, @group);

-- Assuming @id and @group are variables holding the values of $_GET['id'] and $_GET['group']

-- If using MySQL 8+
SET @groepsindeling = COALESCE(@id, @group);