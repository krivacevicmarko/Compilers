main_body {
        num_int niz1 := {1,3,4,6,8} ;
        num_int niz2 := {0,2,5,7,9} ;
        num_int i ;
        for (i:=0;i<5;i:=i+1) {
            if (niz1[i]>niz2[i]) {
                prints niz1[i] ;
            } else {
                prints niz2[i] ;
            }
        }
    }