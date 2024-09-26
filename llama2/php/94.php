<?php

function user($user_id) {
    // your user function code here
    echo "User ID: $user_id";
}

class Uri {
    function segment($segment) {
        // your uri segment code here
        $uri = explode('/', $_SERVER['REQUEST_URI']);
        return isset($uri[$segment]) ? $uri[$segment] : false;
    }
}

class Main {
    function __construct() {
        $this->uri = new Uri();
    }

    function run() {
        if($this->uri->segment(3)){
            $user_id = $this->uri->segment(3);
            user($user_id);
        }else{
            return FALSE;
        }
    }
}

$main = new Main();
$main->run();

?>