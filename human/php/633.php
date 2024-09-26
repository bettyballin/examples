use Symfony\Component\Security\Core\User\UserInterface;

security:
  firewalls:
    secured_area:
      pattern:    ^/
      user: true
      form_login:
        login_path: /login
        check_path: /check_login                
      logout: ~