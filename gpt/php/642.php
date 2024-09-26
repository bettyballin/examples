
if ($userIsAuthorized) {
    $file = '/var/www/private_files/0001.jpg';
    header('Content-Type: image/jpeg');
    header('Content-Disposition: attachment; filename
