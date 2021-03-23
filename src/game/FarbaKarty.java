package game;

import java.awt.*;

public final class FarbaKarty {  //HEX format farby --> 50 druhova farieb
    private static final int[] farby =
            {0xFFFFFF,              //Biela
                    0x000000,       //Cierna
                    0xFFFF00,       //Zlta
                    0xE83000,       //Cervena
                    0x4FC601,       //Zelena
                    0x1CE6FF,       //Aqua
                    0xFF34FF,       //Pink
                    0x0000A6,       //Modra
                    0x006FA6,       //Zeleno/modra
                    0xFFDBE5,       //Ruzova
                    0xFF913F,       //Oranzova
                    0x7ED379,       //Bledozelena
                    0x008941,       //Tmavozelena
                    0x00FECF,       //Bledozelena2
                    0xFF90C9,       //Ruzova2
                    0xFF2F80,       //Magenta
                    0x1B4400,       //Tmavozelena2
                    0xA079BF,       //Fialova
                    0x575329,       //Zltohneda
                    0x6B002C,       //Tmavoruzova
                    0x404E55,       //Sivozelena
                    0x66E1D3,       //Bledozelena3
                    0xA4E804,       //Zltozelena
                    0x00A6AA,       //Bledozelena4
                    0xD0AC94,       //Bledohneda
                    0xB4A8BD,       //Bledofialova
                    0x938A81,       //Siva
                    0x7A4900,       //Tmavozlata
                    0x6B7900,       //Zltozlata
                    0xCB7E9B,       //Ruzova2
                    0xA77500,       //Zlatohneda
                    0xFFF69F,       //Vanilka
                    0xBF5650,       //Malina
                    0xC0B9B2,       //Siva2
                    0xA30059,       //Magenta2
                    0x788D66,       //Sivozelena
                    0x012C58,       //Tmavomodra
                    0xBEC459,       //Bledozlta
                    0xFFAA92,       //Bledocervena
                    0x922329,       //Bordova
                    0x372101,       //Tmavohneda
                    0xFFB500,       //Okrova
                    0x7B4F4B,       //Sivocervena
                    0xC2FFED,       //Bledozelena5
                    0x7900D7,       //Kriklavofialova
                    0x8FB0FF,       //Azurova
                    0x0086ED,       //Skyblue
                    0xFF4A46,       //Bledocervena2
                    0xD790FF,       //Bledofialova2
                    0xFFFF66};      //Bledozlta2

    public static Color getFarbaKarty(int index) {
        return new Color(farby[index]);
    }
}
