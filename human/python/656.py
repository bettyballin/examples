import xgboost as xgb
import numpy as np

# Assuming you have your training and testing data in X_train, y_train and X_test
X_train = np.array([[1, 2], [3, 4], [5, 6]])
y_train = np.array([0, 1, 2])
X_test = np.array([[7, 8], [9, 10]])

# Convert data to xgb format
D_train = xgb.DMatrix(X_train, label=y_train)
D_test = xgb.DMatrix(X_test)

param = {
    'eta': 0.1, 
    'max_depth': 1,  
    'objective': 'multi:softprob',  
    'num_class': 3} 

steps = 20  # The number of training iterations
model = xgb.train(param, D_train, steps)
preds = model.predict(D_test)