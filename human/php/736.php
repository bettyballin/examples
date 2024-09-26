<?php

class DataBase {
  public static function doSomething() {
      $allowed = false;
      foreach(debug_backtrace() as $trace) {
         switch($trace['class']) {
          case 'Core':
          case 'AnotherAllowedClass':
          $allowed = true;
          break 2;
        }
      }
      if(!$allowed)
       throw new Exception('denied');
      /* do stuff */
      echo "Doing something...\n";
    }
  }
}

class Core {
  public function test() {
    DataBase::doSomething();
  }
}

class AnotherAllowedClass {
  public function test() {
    DataBase::doSomething();
  }
}

class NotAllowedClass {
  public function test() {
    try {
      DataBase::doSomething();
    } catch (Exception $e) {
      echo $e->getMessage() . "\n";
    }
  }
}

$core = new Core();
$core->test();

$allowed = new AnotherAllowedClass();
$allowed->test();

$notAllowed = new NotAllowedClass();
$notAllowed->test();

?>