
if (Yii::app()->user->isGuest) {
    echo 'Not Authenticated';
    Yii::app()->end();
}

