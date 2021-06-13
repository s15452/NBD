//5.	Średnia i łączna ilość środków na kartach kredytowych kobiet narodowości polskiej w podziale na waluty. ,

printjson(db.people.aggregate([
    {$match: {sex: "Female", nationality: "Poland"}},
    {$unwind: "$credit"},
    {$group: {
        _id: "$credit.currency", 
        avg: {$avg: {$toDouble: "$credit.balance"}}, 
        sum: {$sum: {$toDouble: "$credit.balance"}}
    }
    }
]).toArray())


