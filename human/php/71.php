<?php
  header('WWW-Authenticate: Basic realm="Protected"');
  header('HTTP/1.0 401 Unauthorized');

  $auth_user_file = '/home/user/www/protected/.htpasswd';

  if (isset($_SERVER['PHP_AUTH_USER']) && isset($_SERVER['PHP_AUTH_PW'])) {
    $username = $_SERVER['PHP_AUTH_USER'];
    $password = $_SERVER['PHP_AUTH_PW'];

    $file = fopen($auth_user_file, 'r');
    while ($line = fgets($file)) {
      list($user, $pass) = explode(':', $line);
      if ($user == $username && crypt($password, $pass) == $pass) {
        echo 'Welcome, ' . $username . '!';
        exit;
      }
    }
    fclose($file);
  }

  echo 'Invalid username or password';
  exit;
?>