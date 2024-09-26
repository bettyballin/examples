<?php
if (isset($_GET['foo']) && $_GET['foo'] == 'bar') {
    include('bar.php');
} else {
    throw new \Exception('Invalid foo parameter');
}
?>