//4.	Średnie, minimalne i maksymalne BMI (waga/wzrost^2) dla osób w bazie, w podziale na narodowości; 

printjson(db.people.aggregate([
    {
        $group:{
            _id: "$nationality",
            avg: {$avg: { $divide: [{$toDouble: "$weight"}, {$sqrt:{$toDouble: "$height"}}]}},
            min: {$min: { $divide: [{$toDouble: "$weight"}, {$sqrt:{$toDouble: "$height"}}]}},
            max: {$max: { $divide: [{$toDouble: "$weight"}, {$sqrt:{$toDouble: "$height"}}]}}
        }
    }
]).toArray())


