
public function authenticate(Request $request): PassportInterface {
    $userIdentifier = strtolower($this->getUserIdentifierFromRequest());
    
    return new Passport(
        new UserBadge($userIdentifier, function($userIdentifier) {
            // Your user loading logic here, ensure it also performs a case-insensitive search
            // For example, you could explicitly query with LOWER() in SQL if necessary
            ...
        }),
        new CustomCredentials(
            function ($credentials, UserInterface $user) {
                ...
            },
            $
