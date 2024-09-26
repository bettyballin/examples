<?php

class UserVisibleException extends Exception {}

function abort($message) {
    throw new UserVisibleException($message);
}

try {
    abort('Something went wrong!');
} catch (Exception $exc) {
    if ($exc instanceof UserVisibleException) {
        print $exc->getMessage();
    } else {
        print "An internal error occurred.";
    }
}

?>