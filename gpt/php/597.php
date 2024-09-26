
   $app->register(new Silex\Provider\SecurityServiceProvider(), array(
       'security.firewalls' => array(
           'user' => array(
               'pattern' => '^/user',
               'form' => array('login_path
