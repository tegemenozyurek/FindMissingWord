public class MissingWordDemo {

    public static void main(String[] args) {
        char[][] letterGrid = {
                {'E', 'N', 'W', 'K', 'B', 'J', 'J', 'C', 'M', 'N', 'K', 'O', 'Q', 'M', 'E', 'T', 'Y', 'K', 'E', 'B'},
                {'J', 'Z', 'K', 'L', 'D', 'G', 'A', 'Y', 'R', 'A', 'F', 'P', 'T', 'Y', 'X', 'I', 'U', 'O', 'W', 'E'},
                {'X', 'Z', 'V', 'B', 'C', 'E', 'D', 'R', 'K', 'O', 'P', 'M', 'C', 'A', 'Y', 'R', 'R', 'U', 'C', 'I'},
                {'C', 'F', 'L', 'S', 'D', 'T', 'K', 'R', 'O', 'A', 'G', 'W', 'B', 'R', 'V', 'J', 'K', 'H', 'W', 'U'},
                {'U', 'T', 'Q', 'B', 'H', 'L', 'J', 'G', 'B', 'Y', 'Y', 'R', 'F', 'Z', 'P', 'O', 'G', 'X', 'E', 'C'},
                {'O', 'P', 'L', 'C', 'M', 'R', 'K', 'W', 'E', 'E', 'V', 'H', 'J', 'Z', 'X', 'B', 'E', 'T', 'F', 'E'},
                {'Y', 'S', 'V', 'A', 'S', 'U', 'N', 'C', 'T', 'M', 'B', 'A', 'G', 'M', 'Z', 'R', 'H', 'W', 'K', 'F'},
                {'N', 'H', 'C', 'V', 'B', 'P', 'X', 'Y', 'S', 'R', 'L', 'J', 'G', 'K', 'T', 'A', 'W', 'F', 'E', 'D'},
                {'F', 'G', 'U', 'E', 'Y', 'B', 'W', 'O', 'Y', 'I', 'H', 'P', 'X', 'V', 'N', 'K', 'B', 'A', 'J', 'M'},
                {'N', 'X', 'M', 'H', 'T', 'W', 'I', 'G', 'A', 'A', 'U', 'F', 'L', 'N', 'S', 'P', 'R', 'Y', 'D', 'J'},
                {'E', 'E', 'M', 'G', 'W', 'O', 'N', 'F', 'A', 'V', 'T', 'K', 'P', 'O', 'Q', 'B', 'X', 'A', 'U', 'R'},
                {'B', 'R', 'D', 'H', 'N', 'L', 'K', 'J', 'Y', 'M', 'Z', 'A', 'F', 'R', 'C', 'W', 'X', 'R', 'O', 'E'},
                {'B', 'Y', 'P', 'R', 'R', 'L', 'T', 'F', 'J', 'A', 'E', 'I', 'Z', 'B', 'S', 'G', 'M', 'O', 'Q', 'R'},
                {'J', 'K', 'X', 'N', 'A', 'F', 'E', 'S', 'A', 'P', 'W', 'V', 'G', 'E', 'H', 'O', 'B', 'C', 'M', 'L'},
                {'U', 'B', 'E', 'N', 'M', 'H', 'C', 'Z', 'V', 'W', 'L', 'F', 'I', 'L', 'X', 'P', 'D', 'R', 'A', 'H'},
                {'T', 'R', 'C', 'V', 'D', 'B', 'Y', 'L', 'E', 'R', 'G', 'F', 'O', 'P', 'A', 'K', 'H', 'J', 'W', 'N'},
                {'M', 'C', 'J', 'K', 'J', 'O', 'R', 'D', 'A', 'N', 'Y', 'L', 'I', 'W', 'P', 'B', 'A', 'X', 'N', 'U'},
                {'O', 'V', 'L', 'F', 'R', 'U', 'K', 'X', 'M', 'N', 'C', 'T', 'Y', 'Q', 'J', 'W', 'S', 'B', 'I', 'D'},
                {'Q', 'W', 'S', 'L', 'B', 'D', 'F', 'A', 'N', 'M', 'G', 'H', 'J', 'Y', 'I', 'T', 'E', 'P', 'O', 'R'}
        };

        String[] wordlist = {"KOBE", "LEBRON", "JORDAN", "CURRY", "HARDEN", "SHAQ"};

        MissingWord mW = new MissingWord(letterGrid, wordlist);

        System.out.println(mW);

        mW.missingWord(letterGrid);

        for (int i = 0 ; i < wordlist.length ; i++){
            System.out.println(i + ". word: " + wordlist[i]);
        }

        //i couldn't make highlight method. You can find the words in matrix on the image file i uploaded.
        System.out.println("\n"+mW.missingWord(letterGrid));
    }
}
