cpp
#include <iostream>
#include <vector>

class Block {
public:
    int data;
    Block(int data) : data(data) {}
};

class Blockchain {
public:
    std::vector<Block> chain;

    Blockchain() {}

    void addBlock(Block block) {
        chain.push_back(block);
    }

    friend std::ostream & operator<<(std::ostream & out, const Blockchain & p) {
        out << "Blockchain: ";
        for (const auto & block : p.chain) {
            out << block.data << " ";
        }
        return out;
    }
};

int main() {
    Blockchain blockchain;
    blockchain.addBlock(Block(1));
    blockchain.addBlock(Block(2));
    blockchain.addBlock(Block(3));

    std::cout << blockchain << std::endl;

    return 0;
}