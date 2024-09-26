import asyncio
from sqlalchemy import create_engine, bindparam
from sqlalchemy.ext.asyncio import AsyncSession
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy import Column, String

Base = declarative_base()

class Sensor(Base):
    __tablename__ = 'sensors'
    name = Column(String)

async def add_sensor(db_engine, name):
    async with db_engine.acquire() as connection:
        query = Sensor.__table__.insert().values({"name": bindparam("name")})
        await connection.execute(query, {"name": name})

async def main():
    db_engine = create_engine('sqlite:///example.db')
    await add_sensor(db_engine, "example_sensor")

asyncio.run(main())