<?php
if ($userIsLoggedIn && isset($_GET['image'])) {
    $path = '/home/yourusername/upload/' . basename($_GET['image']);

    if (is_file($path)) {
        header('Content-Type: image/jpeg');

        readfile($path);

        exit;
    } else {
        header('HTTP/1.0 404 Not Found');
        echo 'Image not found';
        exit;
    }
} else {
    header('HTTP/1.0 403 Forbidden');
    echo 'Access denied';
    exit;
}


bash
<?php
// For testing purposes, you can set $userIsLoggedIn to true
$userIsLoggedIn = true;


bash
// Run with: php -S localhost:8080
// Access with: http://localhost:8080/?image=image.jpg