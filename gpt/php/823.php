
@if($exception instanceof \Symfony\Component\HttpKernel\Exception\HttpException)
    {{ $exception->getMessage() }}
@else
    An error has occurred
