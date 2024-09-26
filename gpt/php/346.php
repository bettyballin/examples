
public static function redirect($num, $url)
{
    $http = [
        // ... your HTTP status code array
    ];

    // Parse home URL and the provided URL to extract components
    $home_url = parse_url('https://www.yourdomain.com'); // Replace with your domain
    $redirect_url = parse_url($url);

    // Check if the host of the provided URL matches your domain
    if (isset($redirect_url['host']) && $redirect_url['host'] === $home_url['host']) {
        header($http[$num]);
        header("Location: $url");
        exit;
    } else {
        // Optional: Redirect to a default page or show an error
        header($http[$num]);
        header('Location: https://www.yourdomain.com'); // Replace with your desired default URL
        exit;
    }
}

