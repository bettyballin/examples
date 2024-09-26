
require 'vendor/autoload.php';

use Kreait\Firebase\Factory;
use Kreait\Firebase\Exception\Auth\EmailExists as EmailExistsException;

$factory = (new Factory)
    ->withServiceAccount('path/to/your/firebase-service-account.json')
    ->withDatabaseUri('https://your-database-uri.firebaseio.com');

$auth = $factory->createAuth();

$email = "user@example.com";
$password = "your-password";

try {
    $newUser = $auth->createUserWithEmailAndPassword($email, $password);
    
    // Get the uid
