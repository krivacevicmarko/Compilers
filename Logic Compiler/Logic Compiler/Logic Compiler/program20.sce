main_body {
        strng rec1 := "programski" ;
        strng rec2 := "prevodioci" ;
        num_int i := 0 ;
        do {
            if (rec1[0]==rec2[0]) {
                prints "na-indeksu" ;
                prints i ;
                prints ".-imaju-isti-karakter" ;
            } else {
                prints "na-indeksu" ;
                prints i ;
                prints ".-nemaju-isti-karakter" ;
            }
        } while (i<10) ;
    }