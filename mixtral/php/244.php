<?php

class SiteController extends Controller
{
    public function actionLogin()
    {
        // Initialize Yii::$app->session
        if (!Yii::$app->getSession()->isActive) {
            Yii::$app->getSession()->open();
        }
    }
}