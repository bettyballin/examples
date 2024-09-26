<?php
if (in_array ($_SERVER['REMOTE_ADDR'], array ('127.0.0.1', '192.168.1.13')) == false) {
  die ('restricted access');
}
?>