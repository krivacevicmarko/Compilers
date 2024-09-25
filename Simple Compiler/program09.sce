main_body {
        num_double x := 155.551 ;
        num_double y := 155.651 ;
        if (x>y) {
            y := x - y ;
            prints y ;
        } else {
            x := y - x ;
            prints x ;
        }
    }