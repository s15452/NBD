//6.	Dodaj siebie do bazy, zgodnie z formatem danych użytych dla innych osób (dane dotyczące karty kredytowej, adresu zamieszkania i wagi mogą być fikcyjne); 

printjson(db.people.insertOne(
    {
        "sex" : "Male",
        "first_name" : "Michał",
        "last_name" : "Soczewka",
        "job" : "Student",
        "email" : "s15452@pjwstk.edu.pl",
        "location" : {
            "city" : "Warszawa",
            "address" : {
                "streetname" : "Bezpieczna",
                "streetnumber" : "12"
            }
        },
        "description" : "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        "height" : "175",
        "weight" : "87",
        "birth_date" : "1996-09-14T18:22:07Z",
        "nationality" : "Poland",
        "credit" : [
            {
                "type" : "visa",
                "number" : "4532 5100 7262 2381",
                "currency" : "PLN",
                "balance" : "4265.17"
            }
        ]
    }
 ))