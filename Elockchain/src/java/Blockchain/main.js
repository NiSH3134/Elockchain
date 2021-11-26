const SHA256=require('crypto-js/sha246')

class Block{
    constructor(index, timestamp, data, previousHash=''){
        this.index=index;
        this.timestamp=timestamp;
        this.data=data;
        this.previousHash=previousHash;
        this.hash=this.calculateHash();
    }

    calculateHash(){
        return SHA256(this.index + this.previousHash + this.timestamp + JSON.stringify(this.data)).toString();
    }
}

class Blockchain{
    constructor(){
        this.chain = [this.createGenesisBlock()];
    }

    createGenesisBlock()
    {
        return new Block(0,"25/11/2021","Genesis Block","0");
    }

    getLastestBlock(){
        return this.chain[this.chain.length -1]
    }

    addBlock(newBlock){
        newBlock.previousHash=this.getLastestBlock().hash;
        newBlock.hash=newBlock.calculateHash();
        this.chain.push(newBlock);
    }
}

let savjeeCoin=new Blockchain();
savjeeCoin.addBlock(new Block(1, "04/12/2021",{sender:xyz}));
savjeeCoin.addBlock(new Block(1, "04/12/2021",{sender:xyz2}));

console.log(JSON.stringify(savjeeCoin,null,4));