<?php

$data = $_POST['formdata'];

$params = [
    ':artNr' => intval($data['artNr']),
    ':etc'   => htmlspecialchars($data['etc']),
];

?>