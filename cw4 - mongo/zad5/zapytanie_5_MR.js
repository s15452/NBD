//5.	Średnia i łączna ilość środków na kartach kredytowych kobiet narodowości polskiej w podziale na waluty. ,


printjson(db.people.mapReduce(
    function(){ 
        for(var i = 0; i < this.credit.length; i++){
            emit(this.credit[i].currency, {count: 1, balance: parseFloat(this.credit[i].balance)})
        }
    },
    function(key, values){ 

        reducedVal = {count: 0, balance: 0}

        for(var i = 0; i < values.length; i++){
            reducedVal.count += values[i].count
            reducedVal.balance += values[i].balance
        }

        return reducedVal
    },
    {
        query:{sex: "Female", nationality: "Poland"},
        out: {inline:1},
        finalize: function(key, reducedVal){
            reducedVal.avg = reducedVal.balance / reducedVal.count
            return reducedVal
        }
    }
))



