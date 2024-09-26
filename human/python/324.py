from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker
from your_model import model
from flask import request

engine = create_engine('your_database_url')
Session = sessionmaker(bind=engine)
session = Session()

result = session.execute(model.users.__table__.select().where(model.users.name == request.args.get('name')))