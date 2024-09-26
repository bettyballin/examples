
   // getproduct.php
   $upc = filter_input(INPUT_POST, 'upc', FILTER_SANITIZE_STRING);

   $pdo = new PDO('mysql:host=your_host;dbname=your_db', 'username', 'password');
   $stmt = $pdo->prepare('SELECT * FROM products WHERE upc = :upc');
   $stmt->execute([':upc' => $upc]);
   $product = $stmt->fetch(PDO::FETCH_ASSOC);

   // Process $product data and return it to the client
   
