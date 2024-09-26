import boto3

dynamodb = boto3.resource('dynamodb')
table = dynamodb.Table('your_table_name')

user_input = input("Please enter a value: ")

table.update_item(
    Key={'partition_key': 'value'},
    UpdateExpression='SET my_attribute = :val',
    ExpressionAttributeValues={':val': {'S': user_input}}
)