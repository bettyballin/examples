<?php
// Define the html helper
class Html {
    public function url($url) {
        return $url;
    }
}

// Create an instance of the html helper
$html = new Html();

// Create a mock controller
class MyController {
    public $html;

    public function __construct() {
        $this->html = $html;
    }
}

// Create an instance of the mock controller
$this = new MyController();

// The form code
?>

<form action="<?= $this->html->url('/my_controller/save_data') ?>" method="post">