from django.core.cache import cache
import secrets

def get_encryption_key():
    key = None

    # Check if the encryption key is already stored in server-side cache
    cached_key = cache.get('ENCRYPTION_KEY')

    if not cached_key:
        # Retrieve and store the encryption key securely
        key = secrets.token_urlsafe(32)  # Generate a secure encryption key

        # Store it temporarily in Django's cache
        cache.set('ENCRYPTION_KEY', key, timeout=60)  # Expire after one minute

    return cached_key if cached_key else key