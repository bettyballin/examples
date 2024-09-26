
class testClass {
    private $_db_name = 'test_db';
    private $_db_user = 'test_user';
    private $_db_pass = 'test_pass';

    // Accessor for non-sensitive data
    public function getDbName() {
        return $this->_db_name;
    }

    // Do NOT create a getter for sensitive data like _db_user and _db_pass
}

