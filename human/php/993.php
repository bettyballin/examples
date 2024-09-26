<?php
class RequestHelper {
    public function getIsAjaxRequest()
    {
        return isset($_SERVER['HTTP_X_REQUESTED_WITH']) && $_SERVER['HTTP_X_REQUESTED_WITH']==='XMLHttpRequest';
    }
}

$requestHelper = new RequestHelper();
$isAjaxRequest = $requestHelper->getIsAjaxRequest();
var_dump($isAjaxRequest);
?>