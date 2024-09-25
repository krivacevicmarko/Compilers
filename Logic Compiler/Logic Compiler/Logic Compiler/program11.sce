main_body {
        num_int x := 11 ;
        num_int y := 17 ;
        num_int z ;
        prints "Unesite-broj-z-:" ;
        if (x<y&y<z) {
            prints "z-je-vece-od-x-i-y" ;
        } elif (x<y&y>z&z<x) {
            prints "z-je-manje-od-x-i-y" ;
        } elif (x<z&z<y) {
            prints "z-je-vece-od-x-a-manje-od-y" ;
        }
    }