
     // To store in the cookie
     $data = json_encode($favoritesArray);
     setcookie('favorites', $data);

     // To retrieve from the cookie
     $favoritesArray = json_decode($_COOKIE['favorites'], true); // The second parameter 'true' ensures output as an array
     
