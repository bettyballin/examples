public function beforeAction($action)
{
    if (in_array($action->id, ['your-action-name'])) {
        $this->enableCsrfValidation = false;
    }

    return parent::beforeAction($action);
}