
$db = new mysqli($host, $user, $password, $database);

// Check connection
if ($db->connect_error) {
    die("Connection failed: " . $db->connect_error);
}

// Prepare an INSERT statement
$query = $db->prepare("INSERT INTO uniqueBeers (userID, beerID, beerName, beerStyle, beerBrewery, abv, ibu, breweryID, icon, brewIcon) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

// Bind parameters (s for string, i for integer, d for double, etc.)
$query->bind_param('issssdiss', $userID, $beerID, $beerName, $style, $brewery, $abv, $ibu,
