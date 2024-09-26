<?php
$sql = new mysqli("localhost", "my_user", "my_password", "world");

$stmt = $sql->prepare("INSERT INTO Persons (msg, ip, time, main, twit, city, lat, lon, lang)
VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
$stmt->bind_param("sssssssss", $_POST['msg'], $ip, $date, $_POST['main'], $_POST['twit'], $cit, $lat, $lon, $_POST['lang']);
$stmt->execute();
?>