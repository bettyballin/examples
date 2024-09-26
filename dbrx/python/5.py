class Subject:
    def __init__(self, givenName=None, surname=None):
        self.givenName = givenName
        self.surname = surname

subject = Subject(givenName=b'John', surname=b'Doe')

given_name = subject.givenName.decode('utf-8') if hasattr(subject, 'givenName') else None
surname = subject.surname.decode('utf-8') if hasattr(subject, 'surname') else None

print(f'Given name: {given_name}')
print(f'Surname: {surname}')