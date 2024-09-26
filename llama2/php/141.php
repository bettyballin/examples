<?php
$db = new PDO('mysql:host=localhost;dbname=mydatabase', 'username', 'password');

// Prepare the query with placeholders for the user input
$stmt = $db->prepare("INSERT INTO mytable (beerID, beerName, style, brewery, abv, ibu, breweryID, icon, brewIcon) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

// Sample user input
$beerID = 1;
$beerName = 'Sample Beer';
$style = 'Sample Style';
$brewery = 'Sample Brewery';
$abv = 5.0;
$ibu = 50;
$breweryID = 1;
$icon = 'sample_icon.png';
$iconBrew = 'sample_brew_icon.png';

// Bind the user input to the query placeholders
$stmt->bindParam(1, $beerID);
$stmt->bindParam(2, $beerName);
$stmt->bindParam(3, $style);
$stmt->bindParam(4, $brewery);
$stmt->bindParam(5, $abv);
$stmt->bindParam(6, $ibu);
$stmt->bindParam(7, $breweryID);
$stmt->bindParam(8, $icon);
$stmt->bindParam(9, $iconBrew);

// Execute the query
$stmt->execute();
?>