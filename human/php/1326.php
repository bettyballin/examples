<?php
class PageLoader {
    private $moduleDir;
    private $pageVal;

    public function __construct($moduleDir) {
        $this->moduleDir = $moduleDir;
    }

    public function loadPage() {
        $this->pageVal = basename($_GET['file']);
        $file = $this->moduleDir . $this->pageVal . ".php";
        if (!is_readable($file)) {
            trigger_error("User attempted to access non-existent code: " 
              . base64_encode($_GET['page']), E_USER_WARNING);
            $this->pageVal = 'index';
            $file = $this->moduleDir . $this->pageVal . ".php";
        }
        require_once $file;
    }
}

$loader = new PageLoader('/path/to/module/dir/');
$loader->loadPage();