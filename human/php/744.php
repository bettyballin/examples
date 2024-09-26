class User {}

class UnsupportedUserException extends Exception {}

$user = new stdClass();

try {
    if (!$user instanceof User) {
        throw new UnsupportedUserException(sprintf('Instances of "%s" are not supported.', get_class($user)));
    }
} catch (UnsupportedUserException $e) {
    echo $e->getMessage();
}