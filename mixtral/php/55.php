public function actionImage($id)
{
    $model = YourModel::findOne($id);

    if ($model === null || !$this->checkAccessToModel($model)) {
        throw new \yii\web\NotFoundHttpException();
    }

    return Yii::$app->response->sendFile(
        'path/to/' . $model->image_filename,
        $model->image_name
    );
}