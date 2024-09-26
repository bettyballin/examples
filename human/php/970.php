This is not PHP code, it's Apache mod_rewrite rules. However, I can provide you with a PHP script that achieves similar functionality:


<?php
$allowed_referers = array('http://yourwebsite.com', 'http://www.yourwebsite.com');
$allowed_extensions = array('gif', 'png', 'jpg', 'doc', 'xls', 'pdf', 'html', 'htm', 'xlsx', 'docx', 'mp4', 'mov');

$referrer = $_SERVER['HTTP_REFERER'];
$extension = strtolower(pathinfo($_SERVER['REQUEST_URI'], PATHINFO_EXTENSION));

if (!in_array($referrer, $allowed_referers) && in_array($extension, $allowed_extensions) && !isset($_COOKIE['wordpress_logged_in'])) {
    header('Location: http://yourwebsite.com/');
    exit;
}
?>