from itertools import permutations

def get_rearrangement_indices(s1, s2):
    if sorted(s1) != sorted(s2):
        return []
    idx = [i for i, c in enumerate(s1) for j, d in enumerate(s2) if c == d]
    groups = {}
    for i, c in enumerate(s1):
        if c not in groups:
            groups[c] = []
        groups[c].append(i)
    for p in permutations(idx):
        rearrangement = []
        valid = True
        for c in s2:
            if not groups[c]:
                valid = False
                break
            i = groups[c].pop(0)
            rearrangement.append(i)
        if valid:
            yield tuple(rearrangement)

print(list(get_rearrangement_indices("abaca", "cabaa")))
print(list(get_rearrangement_indices("aabb", "abab")))