<?php
class Application_Model_DbTable_MyTable extends Zend_Db_Table_Abstract {

    //actual name of database table
    protected $_name = 'My_Table';
    //name of primary key
    protected $_primary = 'id';

}