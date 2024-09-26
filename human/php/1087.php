<?php

use yii\web\User;

$model = User::findIdentity($id);
$model->scenario = User::SCENARIO_USER_SAVE; // use the scenario

if ($model->load(Yii::$app->request->post())) {
    if ($model->save()) {
        // your code here
    }
}