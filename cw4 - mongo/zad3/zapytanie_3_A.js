//3.	Listę unikalnych zawodów; 

printjson(db.people.aggregate([
    {
        $group:{
            _id: { job: "$job"}
        }
    }
]).toArray())


