//4.	Średnie, minimalne i maksymalne BMI (waga/wzrost^2) dla osób w bazie, w podziale na narodowości; 

printjson(db.people.mapReduce(
    function(){ 
        emit(this.nationality,{count: 1, bmi: (parseFloat(this.weight) / Math.pow(parseFloat(this.height)/100, 2)) })
    },
    function(key, values){ 
        reducedVal = {count: 0, bmi: 0, minBMI: values[0].bmi, maxBMI: values[0].bmi}
        
        for(var i = 0; i < values.length; i++){

            reducedVal.count += values[i].count
            reducedVal.bmi += values[i].bmi

            if(reducedVal.minBMI > values[i].bmi){
                reducedVal.minBMI = values[i].bmi
            }
            if(reducedVal.maxBMI < values[i].bmi){
                reducedVal.maxBMI = values[i].bmi
            }
        }

        return reducedVal
    },
    {
        query:{},
        out: {inline:1},
        finalize: function(key, reducedVal){
            reducedVal.avgBMI = reducedVal.bmi / reducedVal.count
            return reducedVal
        }
    }
))




