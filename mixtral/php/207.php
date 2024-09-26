<?php
if (isset($_POST['YII_CSRF_TOKEN'])) {
   if (!Yii::app()->request->validateCsrfToken($_POST['YII_CSRF_TOKEN'], false)) {
       throw new CHttpException(403, 'Invalid CSRF token.');
    }
}