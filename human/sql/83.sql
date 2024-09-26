php
<?php
$pdo = new PDO('mysql:host=localhost;dbname=mydatabase', 'username', 'password');

$a = 'value1';
$b = 'value2';
$c = 'value3';

$sql = "INSERT INTO mytable (columna, columnb, columnc) VALUES (?, ?, ?)";
$stmt = $pdo->prepare($sql);
$stmt->execute([$a, $b, $c]);
?>