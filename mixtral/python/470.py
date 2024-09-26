import base64
from sqlalchemy import select
from sqlalchemy.ext.asyncio import AsyncSession
from typing import List

async def db_get_users(db: AsyncSession) -> List[Users]:
    result = await db.execute(select(Users))

    users = []
    # Decryption
    for user in result.scalars().all():
        try:
            decrypted_phone_number = base64.b64decode(user.phone_number).decode()
            if not isinstance(decrypted_phone_number, str):
                print("Decrypting phone number failed")
            else:
                user.phone_number = decrypted_phone_number
                users.append(user)
        except Exception as e:
            print(f"Error decrypting phone number: {e}")

    return users