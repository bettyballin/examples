
public function actionLogin()
{
    if (!Yii::$app->user->isGuest) {
        return $this->redirect(Yii::$app->request->baseUrl.'/todo/index');
    }

    $model = new LoginForm();
    if ($model->load(Yii::$app->request->post()) && $model->login()) {
        // Once the user is logged in, you can access user details like this:
        $username = Yii::$app->user->identity->username;
        $email = Yii::$app->user->identity->email;
        // You can now use these details to do what you need within your application.

        return $this->redirect(Yii::$app->request->baseUrl.'/todo/index');
    }

    return $this->render('login', [
        '
