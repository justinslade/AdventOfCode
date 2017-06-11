package za.co.justinslade.AdventOfCode;


public class AdventOfCode18 {

    /**
     * first param input based on the firstRow .^^.^.^^^^
     * second param number of rows
     * @param args
     */
    public static void main(String... args) {
        String currentRow = args[0];
        int rows = Integer.parseInt(args[1]);
        int totalSafe = 0;
        for (int i = 0; i < rows; i++) {
            totalSafe += getNumberOfSafeTiles(currentRow);
            currentRow = getNextRow(currentRow);
        }
        System.out.println(totalSafe);
    }

    /**
     * ^^. .^^ ^.. ..^
     *  ^   ^   ^   ^
     * @param currentRow
     * @return
     */
    public static String getNextRow(String currentRow) {
        int length = currentRow.length();
        String[] split = String.format(".%s.", currentRow).split("");
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            if(split[i+1].equals("^") && split[i+2].equals("^") && split[i+3].equals(".")){
                sb.append("^");
            } else if(split[i+1].equals(".") && split[i+2].equals("^") && split[i+3].equals("^")){
                sb.append("^");
            } else if(split[i+1].equals("^") && split[i+2].equals(".") && split[i+3].equals(".")){
                sb.append("^");
            } else if(split[i+1].equals(".") && split[i+2].equals(".") && split[i+3].equals("^")){
                sb.append("^");
            } else {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    private static int getNumberOfSafeTiles(String currentRow) {
        return currentRow.replace("^","").length();
    }

}
