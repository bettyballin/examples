from fastapi import Depends, HTTPException, status
from fastapi.security import OAuth2PasswordBearer
from jose import jwt, JWTError
from pydantic import BaseModel

# Define your SECRET_KEY and ALGORITHM
SECRET_KEY = "your-secret-key"
ALGORITHM = "your-algorithm"

# Define your OAuth2 scheme
oauth2_scheme = OAuth2PasswordBearer(tokenUrl="token")

class TokenData(BaseModel):
    username: str

async def get_current_user(token: str = Depends(oauth2_scheme)):
    credentials_exception = HTTPException(
        status_code=status.HTTP_401_UNAUTHORIZED,
        detail="Could not validate credentials",
        headers={"WWW-Authenticate": "Bearer"}
    )
    try:
        payload = jwt.decode(token, SECRET_KEY, algorithms=[ALGORITHM])
        username: str = payload.get("sub")
        scopes = set(payload.get("scopes", []))
        if username is None or len(scopes) == 0:
            raise credentials_exception
       
        # Verify user scope here.
        token_data = TokenData(username=username)
    except JWTError:
        raise credentials_exception

    user = Users.search(where('name') == token_data.username)

    if not user or set(user[0]['scopes']) != scopes:
        raise HTTPException(
            status_code=status.HTTP_401_UNAUTHORIZED,
            detail="Could not validate credentials",
            headers={"WWW-Authenticate": "Bearer"}
        )
    return user