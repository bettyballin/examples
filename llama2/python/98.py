import asyncio
from sqlalchemy import create_engine, insert
from sqlalchemy.ext.asyncio import AsyncSession, create_async_engine
from sqlalchemy.orm import sessionmaker

# Assuming the model is defined elsewhere
from your_module import model

async def add_sensor(db_engine, name):
    async with db_engine.acquire() as connection:
        query = model.Sensor.__table__.insert().values(name=name)
        await connection.execute(query)

# Usage
async def main():
    db_engine = create_async_engine('your_database_url')
    async with db_engine.begin() as connection:
        await add_sensor(db_engine, 'Sensor Name')

asyncio.run(main())