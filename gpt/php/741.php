
    $valid_tables = array('table1', 'table2', 'table3');
    if (!in_array($table, $valid_tables)) {
        throw new Exception("Invalid table name");
    }
    
