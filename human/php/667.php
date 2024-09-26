This is not PHP code, it's Apache mod_rewrite rules. However, I can provide you with a PHP script that achieves the same functionality:


<?php
$domains = array('yourdomain.com', 'yourotherdomain.com');
$path = 'path/to/user/';
$extensions = array('jpg', 'jpeg', 'gif', 'png', 'tiff');
$hotlink_image = 'http://yourdomain.com/do_not_hot_link.png';

if (!empty($_SERVER['HTTP_REFERER'])) {
    $referer = parse_url($_SERVER['HTTP_REFERER']);
    if (!in_array($referer['host'], $domains)) {
        $file = basename($_SERVER['REQUEST_URI']);
        $file_ext = strtolower(pathinfo($file, PATHINFO_EXTENSION));
        if (strpos($_SERVER['REQUEST_URI'], $path) === 0 && in_array($file_ext, $extensions)) {
            header('Location: ' . $hotlink_image);
            exit;
        }
    }
}
?>