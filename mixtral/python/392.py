from datetime import datetime, timedelta
from fastapi import Depends, HTTPException, status
from fastapi.security import OAuth2PasswordBearer
import jwt

SECRET_KEY = "your_secret_key_here"
ALGORITHM = "your_algorithm_here"

oauth2_scheme = OAuth2PasswordBearer(tokenUrl="token")

@router.get('/user/me')
async def get_current_user(token: str = Depends(oauth2_scheme)):
    credentials_exception = HTTPException(
        status_code=status.HTTP_401_UNAUTHORIZED,
        detail="Could not validate credentials",
        headers={"WWW-Authenticate": "Bearer"}
    )

    try:
        payload = jwt.decode(token, SECRET_KEY, algorithms=[ALGORITHM])

        # Check if token has expired
        current_time = datetime.utcnow()

        if 'exp' in payload and datetime.utcfromtimestamp(payload['exp']) < current_time:
            raise credentials_exception

        username: str = payload.get("sub")

        # ... rest of your code