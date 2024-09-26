<?php
session_start();

class Views {
    public function __construct() {}
}

class AdminView extends Views {
    public function doSomething() {
        echo "Admin view";
    }
}

class RegularView extends Views {
    public function doSomething() {
        echo "Regular view";
    }
}

if ($_GET['foo'] == 'bar' && $_SESSION['isAdmin']) {
    $view = new Views\AdminView();
} else {
    $view = new Views\RegularView();
}
$view->doSomething();
?>