import boto3

dynamodb = boto3.resource('dynamodb')

table_name = 'my-table'
item = {
    'username': 'John Doe',
    'email': 'johndoe@example.com',
    'age': 30
}

dynamodb.Table(table_name).put_item(Item=item)