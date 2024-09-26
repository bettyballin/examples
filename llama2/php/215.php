<?php

class ComponentDatabase {
    public static function getEscaped($value) {
        // Assuming this function escapes the input for database queries
        return addslashes($value);
    }

    public static function loadResult($query) {
        // Assuming this function executes a database query and returns the result
        $db = new mysqli('localhost', 'username', 'password', 'database');
        $result = $db->query($query);
        $row = $result->fetch_assoc();
        return $row['element'];
    }
}

$filter = ''; // Define the filter variable
$option = ''; // Define the option variable

$option = ComponentDatabase::getEscaped($option);
$component = ComponentDatabase::loadResult("SELECT `element` FROM `#__extensions` WHERE `type` = 'component' AND `element` NOT IN ({$filter}) AND `element` = '{$option}'");

print_r($component);

?>