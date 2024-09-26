
$db = new SQLite3($db_name);

$stmt = $db->prepare("INSERT INTO PURCHASE(quantity, name, password, mail) VALUES (:Quantity, :Name, :Password, :Mail)");

$stmt->bindValue(':Quantity', $Quantity, SQLITE3_TEXT);
$stmt->bindValue(':Name', $Name, SQLITE3_TEXT);
$stmt->bindValue(':Password', $Password, SQLITE3_TEXT);
$stmt->bindValue(':Mail', $Mail, SQLITE3_TEXT);

$result = $stmt->execute(); // Use execute(), not exec()

if (!$result) {
    throw new Exception($db->lastErrorMsg());
}

// You can't echo the $stmt like you would with a string because it's an object.
// If you want to see the prepared statement for debugging,
