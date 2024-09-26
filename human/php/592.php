/private
    /view
        profile.php
        search.php
    /libs
    index.php

/public_html
    /css
    /images
    index.php


Here is the modified PHP code:

**/private/index.php**

<?php
define('ROOT_DIR', dirname(__DIR__));
require_once ROOT_DIR . '/private/libs/autoload.php';

$router = new Router();
$router->route();


**/private/libs/autoload.php**

<?php
spl_autoload_register(function ($class) {
    $file = __DIR__ . '/' . str_replace('\\', '/', $class) . '.php';
    if (file_exists($file)) {
        require_once $file;
    }
});


**/private/libs/Router.php**

<?php
class Router {
    public function route() {
        $url = $_SERVER['REQUEST_URI'];
        $path = explode('/', $url);

        if ($path[1] == 'profile') {
            require_once ROOT_DIR . '/private/view/profile.php';
        } elseif ($path[1] == 'search') {
            require_once ROOT_DIR . '/private/view/search.php';
        } else {
            require_once ROOT_DIR . '/public_html/index.php';
        }
    }
}


**/private/view/profile.php**

<?php
// Profile view code here


**/private/view/search.php**

<?php
// Search view code here


**/public_html/index.php**

<?php
// Public index code here


**.htaccess** (in /public_html directory)

RewriteEngine On
RewriteCond %{REQUEST_FILENAME} !-f
RewriteCond %{REQUEST_FILENAME} !-d
RewriteRule ^(.*)$ /index.php?_url=$1 [QSA,L]