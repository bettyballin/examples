function encodePasswordInA1Format($username, $realm, $password) {
    $a1 = $username . ":" . $realm . ":" . $password;
    $a1Md5 = md5($a1);

    return $a1Md5;
}