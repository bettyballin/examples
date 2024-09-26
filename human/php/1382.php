function mergePasswordAndSalt($password, $salt, $strict) {
    if ($password === null) {
        $password = "";
    }

    if ($strict && ($salt !== null)) {
        if ((strpos(strrev($salt), "{") !== false)
                || (strpos(strrev($salt), "}") !== false)) {
            throw new Exception("Cannot use { or } in salt");
        }
    }

    if (($salt === null) || $salt == "") {
        return $password;
    } else {
        return $password . "{" . (string)$salt . "}";
    }
}