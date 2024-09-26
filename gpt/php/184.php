
   $cookieValue = $_COOKIE['your_cookie_id'];
   $cookieValue = filter_var($cookieValue, FILTER_VALIDATE_INT) ?? 'default_value';
   
