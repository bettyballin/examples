
$authorized_token = 'YOUR_SECRET_TOKEN'; // this should be a secure token

if ($_SERVER['HTTP_AUTHORIZATION'] !== 'Bearer ' . $authorized_token) {
    show_error("Daily CRON tasks can only be run from the command line on the live server.");
}

