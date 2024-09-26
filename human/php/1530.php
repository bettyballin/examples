public function render($request, Throwable $exception)
{
    if ($exception->getStatusCode() === 403) {
        abort(404);
    }

    return parent::render($request, $exception);
}