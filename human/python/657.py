import boto3

dynamo = boto3.client('dynamodb')
response = dynamo.scan(TableName = 'my-table', Select = 'ALL_ATTRIBUTES', 
                ScanFilter = {'username': {"AttributeValueList": [{"S": "*"}],
                                             "ComparisonOperator": "GT"}})

print(response)