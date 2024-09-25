main_body {
        num_int x := 11 ;
        num_int y := 17 ;
        num_int z := 15 ;
        do {
            x := x + 1 ;
            y := y - 1 ;
            if (y>z) {
                prints y ;
            } else {
                prints "y-je-manje-od-z" ;
            }
        } while (x<y) ;
    }