<?php
$ora_connection = oci_connect('username', 'password', 'tns');
$query = "SELECT * FROM table_name WHERE id = ".oci_escape_string($id);
$stmt = oci_parse($ora_connection, $query);
oci_execute($stmt);
$result = oci_fetch_all($stmt, $res);
print_r($res);
?>