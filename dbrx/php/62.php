public function actionViewImage($id)
{
    $user = User::findOne($id);
    
    if (Yii::$app->user->can('viewUserImage', ['model' => $user])) {
        return Yii::$app->response->sendFile(Yii::getAlias('@webroot') . '/' . $user->image_path);
    } else {
        throw new ForbiddenHttpException('You do not have permission to view this image.');
    }
}