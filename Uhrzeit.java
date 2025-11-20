public class Uhrzeit {
    public static void main(String[] args) {

        //Nach der "Stunden- und Minuten-Zahl" fragen
        Out.println("Gibt eine Zahl für die Stunde ein (1-12): ");
        int h = In.readInt();

        Out.println("Gibt eine Zahl für die Minute ein (0-59): ");
        int min = In.readInt();


        // Ausgabe  von *** wenn Eingabe nicht gültig
        if (!isInputValid(h, min)) {
            Out.println("***");
            return;
        }

        // Nächste Stunde (12)
        int next = nextHour12(h);

        // Sonderfälle ausgeben
        if (min == 0) {
            Out.println("punkt " + hourToWords(h) + " Uhr");
            return;
        }
        if (min == 15) {
            Out.println("viertel nach " + hourToWords(h) + " Uhr");
            return;
        }
        if (min == 30) {
            Out.println("halb " + hourToWords(next) + " Uhr");
            return;
        }
        if (min == 45) {
            Out.println("dreiviertel " + hourToWords(next) + " Uhr");
            return;
        }

        // Standardfall
        Out.println(hourToWords(h) + " Uhr " + minuteWord(min));

    }





    //Überprüfung der Gültigkeit der Eingabe
    static boolean isInputValid(int h, int min) {
        return (h >= 1 && h <= 12) && (min >= 0 && min <= 59);
    }

    // Nächste Stunde (12)
    static int nextHour12(int h) {
        return (h == 12) ? 1 : (h + 1);
    }

    // Wörter für die Stunde
    static String hourToWords(int h) {
        switch (h) {
            case 1:  return "ein";
            case 2:  return "zwei";
            case 3:  return "drei";
            case 4:  return "vier";
            case 5:  return "fünf";
            case 6:  return "sechs";
            case 7:  return "sieben";
            case 8:  return "acht";
            case 9:  return "neun";
            case 10: return "zehn";
            case 11: return "elf";
            case 12: return "zwölf";
            default: return ""; // sollte wegen "isInputValid" nicht passieren
        }
    }



    // Minuten (1..59) als Wörter (ohne den Sonderfällen, weil die sind oben schon seperat)
    static String minuteWord(int m) {
        if (m < 20) return belowTwentyStandalone(m);
        int tens = (m / 10) * 10;   // 20,30,40,50
        int ones = m % 10;
        if (ones == 0) return tensWord(tens);
        String onesWord = (ones == 1) ? "ein" : belowTwentyStandalone(ones); // "einund..."
        return onesWord + "und" + tensWord(tens);
    }

    // 0..19 (Einzelformen; 1 = "eins", außer in Zusammensetzungen)
    static String belowTwentyStandalone(int n) {
        switch (n) {
            case 0:
                return "null";
            case 1:
                return "eins";
            case 2:
                return "zwei";
            case 3:
                return "drei";
            case 4:
                return "vier";
            case 5:
                return "fünf";
            case 6:
                return "sechs";
            case 7:
                return "sieben";
            case 8:
                return "acht";
            case 9:
                return "neun";
            case 10:
                return "zehn";
            case 11:
                return "elf";
            case 12:
                return "zwölf";
            case 13:
                return "dreizehn";
            case 14:
                return "vierzehn";
            case 15:
                return "fünfzehn";
            case 16:
                return "sechzehn";
            case 17:
                return "siebzehn";
            case 18:
                return "achtzehn";
            case 19:
                return "neunzehn";
            default:
                return "";
        }
    }

    // 20/30/40/50 (--> brauchen wir für das Zusammensetzen der ausgeschriebenen Zeiten)
    static String tensWord(int t) {
        switch (t) {
            case 20:
                return "zwanzig";
            case 30:
                return "dreißig";
            case 40:
                return "vierzig";
            case 50:
                return "fünfzig";
            default:
                return "";
        }
    }
}