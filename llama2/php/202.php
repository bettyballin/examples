<?php
// If the site is down for updates
if (isset($_SERVER['SCRIPT_FILENAME']) && basename($_SERVER['SCRIPT_FILENAME']) == 'update.php') {
    header('Location: /maintenance');
    exit;
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Site Down for Updates</title>
</head>
<body>
    <h1>We're Sorry!</h1>
    <p>Our site is currently down for updates. We apologize for any inconvenience this may cause and will be back up as soon as possible.</p>
    <p><a href="https://www.google.com">Click here to visit Google</a></p>
</body>
</html>

To run this code, save it as `maintenance.php` and upload it to your server. Then, create a new file named `update.php` and add the following line of code to trigger the redirect:

<?php include 'maintenance.php'; ?>