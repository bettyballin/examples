
   $mysqli = mysqli_init();
   $mysqli->ssl_set(
       '/path/to/client-key.pem',
       '/path/to/client-cert.pem',
       '/path/to/ca-cert.pem',
       NULL,
       NULL
   );
   $mysqli->real_connect('hostname', 'username', 'password', 'database', 3306, NULL, MYSQLI_CLIENT_SSL);
   
