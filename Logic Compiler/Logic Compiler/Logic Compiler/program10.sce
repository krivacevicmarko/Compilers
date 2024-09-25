main_body {
        num_int a := 20 ;
        num_int b := 45 ;
        num_int c ;
        for ( num_int i := 0 ; i < 10 ; i := i + 1 ) {
            prints i ;
        }
        if ( a > b ) {
            c := a - b ;
            prints c ;
        } elif ( a < b || a == b ) {
            prints b - a ;
        } else {
            c := a / b ;
            prints c ;
        }
    }