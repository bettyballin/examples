<?php
$d=new DateTime (" <script> malicious </script>");
#test
echo $d->format("y");
/*will cause something like 
Fatal error: Uncaught Exception: DateTime::__construct(): Failed to parse time string ( <script> malicious </script>)*/
?>