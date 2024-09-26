<?php

class ParentClass {
  public function getCredentials() {
    return array();
  }
}

class ChildClass extends ParentClass {
  private $type;

  public function getType() {
    return $this->type;
  }

  public function setType($type) {
    $this->type = $type;
  }

  public function getCredentials(){
    $credentials = parent::getCredentials();

    // Check for specific condition
    if($this->getType()){
      $credentials[] = 'hasType';
    }

    return $credentials;
  }
}

// Test the code
$child = new ChildClass();
$child->setType(true);
var_dump($child->getCredentials());

$child2 = new ChildClass();
$child2->setType(false);
var_dump($child2->getCredentials());