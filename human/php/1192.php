security:

    # http://symfony.com/doc/current/book/security.html#where-do-users-come-from-user-providers
    providers:
        my_db_provider:
            entity:
                class: AppBundle\Entity\User
                property: username