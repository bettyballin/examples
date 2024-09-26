from sqlalchemy import Column, Integer
from sqlalchemy.ext.declarative import declarative_base

base = declarative_base()


class Base(base):

    __abstract__ = True
    uid = Column(Integer, primary_key=True, autoincrement=True)