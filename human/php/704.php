<?php

class MyController extends Controller
{
    public function filters()
    {
        return array( 'accessControl' ); // Tell Yii to use access rules for this controller
    }
}

$obj = new MyController();
print_r($obj->filters());

?>