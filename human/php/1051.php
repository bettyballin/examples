<?php

exec('service apache2 status', $apacheOutput);
exec('service mysql status', $mysqlOutput);
exec('service mongod status', $mongodOutput);

echo "Apache Status:\n";
print_r($apacheOutput);

echo "\nMySQL Status:\n";
print_r($mysqlOutput);

echo "\nMongoDB Status:\n";
print_r($mongodOutput);

?>