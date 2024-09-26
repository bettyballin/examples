<?php

if ($argc !== 2) {
    echo "Usage: php sql_exploits.php <url>\n";
    exit(1);
}

$url = $argv[1];

$exploit = "UNION SELECT name FROM CachedDomains";

$generated_sql = "
    SELECT url FROM GrabbedURLs 
    WHERE url LIKE '${url}%' 
    LIMIT 1 
    ${exploit};
";

echo "Generated SQL: ${generated_sql}\n";

// Simulate a database connection and query execution
// NOTE: DO NOT TRY THIS ON A REAL DATABASE WITHOUT PERMISSION!
$db = new SQLite3(':memory:');
$db->exec('CREATE TABLE GrabbedURLs (url TEXT)');
$db->exec('CREATE TABLE CachedDomains (name TEXT)');
$db->exec('INSERT INTO CachedDomains (name) VALUES ("Secret Domain")');

$result = $db->query($generated_sql);
while ($row = $result->fetchArray()) {
    echo "Returns: ${row[0]}\n";
}

$db->close();