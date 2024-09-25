main_body {
        num_int brojac := 0 ;
        num_int[] niz ;
        prints "Unesite-elemente-niza-:" ;
        while (brojac<17) {
            scans niz[brojac] ;
            brojac := brojac + 1 ;
        }
        num_int i ;
        prints "clanovi-niza-su-:" ;
        for (i:=0;i<brojac;i:=i+1) {
            prints niz[i] ;
        }
    }