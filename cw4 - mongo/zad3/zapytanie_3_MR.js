//3.	Listę unikalnych zawodów; 

printjson(db.people.mapReduce(
    function(){ 
        emit(this.job, 1)
    },
    function(key, values){ 
        return key
    },
    {
        query:{},
        out: {inline:1}
    }
))



