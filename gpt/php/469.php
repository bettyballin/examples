
$dbh = new PDO('mysql:host=localhost;dbname=test', $user, $pass);

// Prepare the SQL statement with placeholders
$stmt = $dbh->prepare("INSERT INTO your_table (column1, column2) VALUES (:value1, :value2)");

// Bind the user input to the placeholders
$stmt->bindParam(':value1', $_POST['formField1']);
$stmt->bindParam(':value2', $_POST['formField2']);

// Execute the prepared statement
$stmt->execute();

