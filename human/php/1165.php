public function actionLogin()
{
    if (!\Yii::$app->user->isGuest) {
        return $this->redirect(Yii::$app->request->baseUrl.'/todo/index');  
    }

    $model = new LoginForm();
    if ($model->load(Yii::$app->request->post()) && $model->login() ) 
    {
        return $this->redirect(Yii::$app->request->baseUrl.'/todo/index/' . $model->getUser()->username);   
    }

    return $this->render('login', [
        'model' => $model,
    ]);
}