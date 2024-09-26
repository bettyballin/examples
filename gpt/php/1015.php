
   $config = include('/path/to/config.php');
   $mysqli = mysqli_init();
   mysqli_real_connect(
       $mysqli,
       $config['db_host'],
       $config['db_username'],
       $config['db_password'],
       $config['
