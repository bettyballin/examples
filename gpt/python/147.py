
   import environ
   env = environ.Env()

   SECRET_KEY = env('DJANGO_SECRET_KEY')
   EMAIL_HOST_PASSWORD
