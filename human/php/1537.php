services:
    # ....
    app.access_token_user_provider:
        class: App\Security\AccessTokenUserProvider
        arguments:
            - '@App\Repository\UserRepository'