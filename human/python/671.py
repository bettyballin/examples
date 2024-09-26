import itertools
import base64
import sqlalchemy as sa
from sqlalchemy import create_engine

# Define the engine
engine = create_engine('your_database_url')

# Define the Users class
class Users(sa.Base):
    __tablename__ = 'users'
    id = sa.Column(sa.Integer, primary_key=True)
    phone_number = sa.Column(sa.String)

# Define the is_base64 function
def is_base64(mapping):
    try:
        base64.b64decode(mapping['phone_number'])
        return True
    except (ValueError, TypeError):
        return False

with engine.begin() as conn:
    tbl = Users.__table__
    values = conn.execute(
        sa.select(
            tbl.c.id.label('uid'), sa.cast(tbl.c.phone_number, sa.String)
        )
    )
   
    updates = list(itertools.filterfalse(is_base64, values.mappings()))

    stmt = (
        sa.update(tbl)
        .where(tbl.c.id == sa.bindparam('uid'))
        .values(phone_number=sa.bindparam('phone_number'))
    )
    conn.execute(stmt, updates)