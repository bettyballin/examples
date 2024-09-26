<?php

class AuthMiddleware {
    public function handle($request, Closure $next)
    {
        // Check authentication status (e.g session or JWT token validation)
        if (!isset($_SESSION['authenticated']) || $_SESSION['authenticated'] !== true) {
            throw new Exception('Unauthorized', 401);
        }

        // Verify permissions based on roles/users/groups
        if (!in_array('admin', $_SESSION['roles'])) {
            throw new Exception('Forbidden', 403);
        }

        return $next($request);
    }
}

// Example usage
$middleware = new AuthMiddleware();

// Simulate a request
$request = new class {
    public function all() {
        return [];
    }
};

// Simulate a Closure
$next = function ($request) {
    return 'Hello, World!';
};

try {
    echo $middleware->handle($request, $next);
} catch (Exception $e) {
    echo $e->getMessage() . ' - ' . $e->getCode();
}