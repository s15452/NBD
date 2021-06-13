//1.	Średnią wagę i wzrost osób w bazie z podziałem na płeć (tzn. osobno mężczyzn, osobno kobiet); 

//Konwersja na liczbę 
db.people.find().forEach(function(data) {
    db.people.update({
        "_id": data._id,
        "height": data.height,
        "weight": data.weight
    }, {
        "$set": {
            "height": parseFloat(data.height),
            "weight": parseFloat(data.weight)
        }
    });
})

printjson(db.people.mapReduce(
    function(){ 
        emit (this.sex, {count: 1, weight: this.weight, height: this.height})
    },
    function(key, values){ 

        reducedVal = {count: 0, weight: 0, height: 0}

        for(var i = 0; i < values.length; i++){
            reducedVal.count += values[i].count
            reducedVal.weight += values[i].weight
            reducedVal.height += values[i].height
        }

        return reducedVal
    },
    {
        query:{},
        out: {inline:1},
        finalize: function(key, reducedVal){
            reducedVal.avgWeight = reducedVal.weight / reducedVal.count
            reducedVal.avgHeight = reducedVal.height / reducedVal.count
            return reducedVal
        }
    }
))



