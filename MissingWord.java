import java.util.ArrayList;

public class MissingWord {
    char[][] letterGrid;

    String[] wordlist;

    //This array list stores the information of if the word exists or doesn't exist.
    ArrayList<Boolean> isExists = new ArrayList<>();


    //Constructor
    MissingWord(char[][] letterGrid, String[] wordlist, ArrayList<Boolean> isExists){
        this.letterGrid = letterGrid;
        this.wordlist = wordlist;
        this.isExists = isExists;
    }

    //Copy Constructor
    public MissingWord(MissingWord mW){
        this.letterGrid = mW.letterGrid;
        this.wordlist = mW.wordlist;
        this.isExists = mW.isExists;
    }

    //My test constructor
    MissingWord(char[][] letterGrid, String[] wordlist){
        this.letterGrid = letterGrid;
        this.wordlist = wordlist;
    }

    //These methods transform the letter grid matrix into a string to help the search methods.
    String leftToRightLineForm(char[][] matrixToTransform){
        String lineForm = "";

        for (int i = 0 ; i < matrixToTransform.length ; i ++){
            for (int j = 0 ; j < matrixToTransform.length ; j++){
                lineForm += matrixToTransform[i][j];
            }
        }

        return lineForm;
    }
    String rightToLeftLineForm(char[][] matrixToTransform){
        String lineForm = "";

        for (int i = matrixToTransform.length - 1 ; i >= 0; i --){
            for (int j = matrixToTransform.length - 1 ; j >= 0 ; j --){
                lineForm += matrixToTransform[i][j];
            }
        }

        return lineForm;
    }
    String topToDownLineForm(char[][] matrixToTransform){
        String lineForm = "";

        for (int i = 0 ; i < matrixToTransform.length ; i ++){
            for (int j = 0 ; j < matrixToTransform.length ; j++){
                lineForm += matrixToTransform[j][i];
            }
        }

        return lineForm;
    }
    String downToTopLineForm(char[][] matrixToTransform){
        String lineForm = "";

        for (int i = matrixToTransform.length - 1 ; i >= 0; i --){
            for (int j = matrixToTransform.length - 1 ; j >= 0 ; j --){
                lineForm += matrixToTransform[j][i];
            }
        }

        return lineForm;
    }
    String leftBottomToRightTopLineForm(char[][] matrixToTransform){
        String lineForm = "";
        int rows = matrixToTransform.length;
        int cols = matrixToTransform[0].length;

        // Matrix'in alt yarısı
        for (int i = rows - 1; i >= 0; i--) {
            int row = i;
            int col = 0;
            while (row < rows && col < cols) {
                lineForm += matrixToTransform[row][col];
                row++;
                col++;
            }
        }

        // Matrix'in üst yarısı
        for (int j = 1; j < cols; j++) {
            int row = 0;
            int col = j;
            while (row < rows && col < cols) {
                lineForm += matrixToTransform[row][col];
                row++;
                col++;
            }
        }

        return lineForm;
    }
    String rightTopToLeftBottomLineForm(char[][] matrixToTransform){
        return new StringBuilder(leftBottomToRightTopLineForm(matrixToTransform)).reverse().toString();
    }

    //Search Methods
    void horizontalSearch(char[][] letterGrid){
        for (int i = 0 ; i < wordlist.length ; i++){
            if(leftToRightLineForm(letterGrid).contains(wordlist[i]) || rightToLeftLineForm(letterGrid).contains(wordlist[i])){
                //System.out.println(wordlist[i] + ":TRUE");
                isExists.set(i, true);
            }
        }
    }
    void verticalSearch(char[][] letterGrid){
        for (int i = 0 ; i < wordlist.length ; i++){
            if(topToDownLineForm(letterGrid).contains(wordlist[i]) || downToTopLineForm(letterGrid).contains(wordlist[i])){
                isExists.set(i, true);
            }
        }
    }
    void crossSearch(char[][] letterGrid){
        for (int i = 0 ; i < wordlist.length ; i++){
            if(leftBottomToRightTopLineForm(letterGrid).contains(wordlist[i]) || rightTopToLeftBottomLineForm(letterGrid).contains(wordlist[i])){
                isExists.set(i, true);
            }
        }
    }

    //TODO Change to String type method
    String missingWord(char[][] letterGrid){
        String theWord = "";

        for (int i = 0 ; i < wordlist.length ; i++){
            isExists.add(false);
        }

        horizontalSearch(letterGrid);
        verticalSearch(letterGrid);
        crossSearch(letterGrid);

        for (int i = 0 ; i < wordlist.length ; i++){
            if (!isExists.get(i)){
                theWord = wordlist[i];
            }
        }


        return "Missing Word: " + theWord;
    }


    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < letterGrid.length; i++) {
            for (int j = 0; j < letterGrid[i].length; j++) {
                result += letterGrid[i][j] + " ";
            }
            result += "\n";
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] letterGrid = {
                {'K', 'O', 'B', 'E', 'N', 'E', 'D', 'R', 'A', 'H', 'J', 'K', 'L', 'W', 'E', 'K', 'T', 'Y', 'B', 'E'},
                {'S', 'Y', 'D', 'F', 'G', 'A', 'J', 'K', 'L', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'Z', 'X'},
                {'H', 'R', 'W', 'E', 'R', 'T', 'D', 'U', 'I', 'O', 'P', 'Z', 'X', 'C', 'V', 'B', 'N', 'M', 'Q', 'A'},
                {'A', 'R', 'Z', 'X', 'C', 'V', 'B', 'R', 'C', 'Q', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'W'},
                {'Q', 'U', 'F', 'G', 'H', 'J', 'K', 'L', 'O', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'Z', 'X', 'C'},
                {'H', 'C', 'K', 'L', 'W', 'E', 'R', 'T', 'E', 'J', 'I', 'O', 'P', 'Z', 'X', 'C', 'V', 'B', 'N', 'M'},
                {'T', 'Y', 'U', 'I', 'O', 'P', 'Z', 'X', 'R', 'V', 'B', 'N', 'M', 'Q', 'A', 'S', 'D', 'F', 'G', 'H'},
                {'P', 'Z', 'X', 'C', 'V', 'B', 'N', 'M', 'R', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'W', 'E'},
                {'G', 'H', 'J', 'K', 'L', 'W', 'E', 'R', 'Y', 'Y', 'U', 'I', 'O', 'P', 'Z', 'X', 'C', 'V', 'B', 'N'},
                {'X', 'C', 'V', 'B', 'N', 'M', 'Q', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'W', 'E', 'R', 'T'},
                {'L', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'B', 'P', 'Z', 'X', 'C', 'V', 'B', 'N', 'M', 'Q', 'A', 'S'},
                {'M', 'Q', 'A', 'S', 'D', 'F', 'G', 'H', 'L', 'A', 'A', 'Y', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P'},
                {'Z', 'X', 'C', 'V', 'B', 'N', 'M', 'Q', 'A', 'S', 'R', 'F', 'G', 'H', 'J', 'K', 'T', 'W', 'E', 'R'},
                {'C', 'V', 'B', 'N', 'M', 'Q', 'A', 'S', 'D', 'F', 'G', 'R', 'J', 'K', 'L', 'W', 'O', 'R', 'T', 'Y'},
                {'F', 'G', 'H', 'J', 'K', 'L', 'W', 'E', 'R', 'T', 'Y', 'U', 'Y', 'O', 'P', 'Z', 'R', 'C', 'V', 'B'},
                {'D', 'F', 'G', 'H', 'J', 'K', 'Z', 'A', 'L', 'I', 'A', 'B', 'D', 'I', 'O', 'P', 'R', 'X', 'C', 'V'},
                {'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'Z', 'X', 'C', 'V', 'B', 'N', 'M', 'A', 'A', 'S', 'D'},
                {'V', 'B', 'N', 'M', 'Q', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'W', 'E', 'C', 'T', 'Y', 'U'},
                {'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'Z', 'X', 'C', 'V', 'B', 'N', 'M', 'Q', 'A', 'S', 'D', 'F'},
                {'Q', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'N', 'O', 'L', 'E', 'M', 'U', 'I', 'O', 'P', 'Z'}
        };

        String[] wordlist = {"KOBE", "LEBRON", "JORDAN", "CURRY", "HARDEN", "SHAQ"};

        /////////////////////////////// Object created and printed. It's for testing
        MissingWord mW = new MissingWord(letterGrid, wordlist);
        System.out.println(mW);

        System.out.println(""+mW.missingWord(letterGrid));
    }
}
