
   import yaml

   # Use safe_load to parse YAML safely
   with open('user_input.yaml', 'r') as stream:
       data = yaml.safe_load(stream)
   
