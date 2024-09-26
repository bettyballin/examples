import itsdangerous
from difflib import ndiff

s = itsdangerous.URLSafeTimedSerializer('sekrit', expires_in=3600)
token1 = s.dumps({'id': 'foobar'})
token2 = s.dumps({'id': 'foobar'})

print('\n'.join(ndiff(token1.split('.'), token2.split('.'))))