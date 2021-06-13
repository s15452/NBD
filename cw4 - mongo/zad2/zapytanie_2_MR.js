//2.	Łączną ilość środków pozostałych na kartach kredytowych osób w bazie, w podziale na waluty; 

printjson(db.people.mapReduce(
    function(){ 
        for(var i = 0; i < this.credit.length; i++){
            emit(this.credit[i].currency, parseFloat(this.credit[i].balance))
        }
    },
    function(key, values){ 
        return Array.sum(values)
    },
    {
        query:{},
        out: {inline:1}
    }
))



