import os
import dj_database_url

# Parse database configuration from $DATABASE_URL
DATABASES = {}
DATABASES['default'] =  dj_database_url.config()

# Honor the 'X-Forwarded-Proto' header for request.is_secure()
SECURE_PROXY_SSL_HEADER = ('HTTP_X_FORWARDED_PROTO', 'https')

# Allow all host headers
ALLOWED_HOSTS = ['*']

# Static asset configuration
BASE_DIR = os.path.dirname(os.path.abspath(__file__))
STATIC_ROOT = os.path.join(BASE_DIR, 'staticfiles')
STATIC_URL = '/static/'

STATICFILES_DIRS = (
    os.path.join(BASE_DIR, 'static'),
)

if __name__ == "__main__":
    print("DATABASES:", DATABASES)
    print("SECURE_PROXY_SSL_HEADER:", SECURE_PROXY_SSL_HEADER)
    print("ALLOWED_HOSTS:", ALLOWED_HOSTS)
    print("STATIC_ROOT:", STATIC_ROOT)
    print("STATIC_URL:", STATIC_URL)
    print("STATICFILES_DIRS:", STATICFILES_DIRS)