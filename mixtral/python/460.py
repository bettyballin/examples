import boto3

dynamodb = boto3.resource('dynamodb')
table = dynamodb.Table('my_table')

response = table.put_item(
   Item={
        'username': 'janedoe',
        'last_name': 'Doe',
        'account_type': 'standard'
    }
)

print(response)