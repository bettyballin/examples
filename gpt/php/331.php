
   require_once 'HTMLPurifier.auto.php';

   $config = HTMLPurifier_Config::createDefault();
   $purifier = new HTMLPurifier($config);

   $cleanHtml
