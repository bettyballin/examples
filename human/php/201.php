Not possible. The code you provided is an Apache configuration directive, not PHP. It needs to be placed in a .htaccess file or Apache configuration file, not executed as PHP. 

However, if you want to achieve the same effect in PHP, you can use the following code:


$files = glob("*.ini");

foreach ($files as $file) {
    header("HTTP/1.1 403 Forbidden");
    exit;
}