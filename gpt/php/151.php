
   $host = getenv('DB_HOST');
   $username = getenv('DB_USERNAME');
   $password = getenv('DB_PASSWORD');
   $database = getenv('DB_NAME');
   $connection = mysqli_connect($host, $username, $password, $database);
   
