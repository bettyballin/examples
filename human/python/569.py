from pydantic import BaseModel
from typing import Optional
from datetime import datetime

class TokenData(BaseModel):
    username: Optional[str] = None
    expires: Optional[datetime] = None