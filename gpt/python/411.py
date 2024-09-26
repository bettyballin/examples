
import random

def shuffle_bytearray(data, seed):
    prng = random.Random(seed)
    data_list = list(data)
    prng.shuffle(data_list)
    return bytearray(data_list)

def unshuffle_bytearray(shuffled_data, seed):
    prng = random.Random(seed)
    # Create a list of indices to shuffle
    index_list = list(range(len(shuffled_data)))
    prng.shuffle(index_list)
    # Create an unshuffled list of the same size as the shuffled data
    unshuffled_list = [None] * len(shuffled_data)
   
