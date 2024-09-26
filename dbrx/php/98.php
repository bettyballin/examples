<?php

// Define a namespace for your CMS core functionality
namespace Cms\Core;

class Database {
    public static function doSomething()  { 
        echo "Doing something\n"; 
    }
}

function createNewUser() { 
    echo "Creating new user\n"; 
}

// Now in another part of your application (e.g themes)
use Cms\Core\Database;
use function Cms\Core\createNewUser;

Database::doSomething(); // Works fine
createNewUser(); // Works fine