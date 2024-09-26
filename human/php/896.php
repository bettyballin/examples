<?php

class ProgressDialog {
  private $context;
  private $message;
  private $cancelable;

  public function __construct($context) {
    $this->context = $context;
  }

  public function setCancelable($cancelable) {
    $this->cancelable = $cancelable;
  }

  public function setMessage($message) {
    $this->message = $message;
  }

  public function show() {
    echo $this->message . "\n";
  }
}

$context = "My Context";
$pdia = new ProgressDialog($context);
$pdia->setCancelable(false);
$pdia->setMessage("Please wait...");
$pdia->show();

?>