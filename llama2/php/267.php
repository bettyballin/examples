<?php

$model = User::findIdentity($id);

if ($model->load(array_intersect_key(Yii::$app->request->post(), array_flip($model->getAllowedFields())))) {
    if ($model->save()) {
        // Add your logic here for successful save
    } else {
        // Add your logic here for failed save
    }
} else {
    // Add your logic here for failed load
}