<?php
$fh = fopen("test.php","r");
while ($line = fgets($fh)){
echo $line;
}
fclose($fh);
?>