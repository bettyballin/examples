<?php
function getPdoConnection($dsn, $username, $password) {
    try {
        $pdo = new PDO($dsn, $username, $password);
        $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        return $pdo;
    } catch (PDOException $e) {
        echo 'Connection failed: ' . $e->getMessage();
        exit();
    }
}

$pdo = getPdoConnection('sqlsrv:Server=OMG!', 'plainTextUser', 'plainTextPassword');