package solutions.Problem37SudokuSolver;

public class MainClass {
    public static void main(String[] args) throws Throwable {
//        char[][] board =
//                {
//                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//                };
//
//        new Solution().solveSudoku(board);
//        printBoard(board);
//
//        Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
//        String ipToReturn = null;
//
//        while(e.hasMoreElements()) {
//            NetworkInterface n = (NetworkInterface)e.nextElement();
//            Enumeration ee = n.getInetAddresses();
//
//            while(ee.hasMoreElements()) {
//                InetAddress i = (InetAddress)ee.nextElement();
//                String currentAddress = i.getHostAddress();
//                System.out.println("IP address " + currentAddress + " found");
////                if (!i.isLoopbackAddress() && validate(currentAddress)) {
////                    ipToReturn = currentAddress;
////                }
//            }
//        }

        String itemLongDesc = "\t\t\t\tSN 碧然德 FB2020B1 电热过滤水壶   黑色   额定功率：2000W\n 额定容量：1.8L";
        System.out.println(itemLongDesc);
        itemLongDesc = itemLongDesc.replace('\n', ' ').replace('\t', ' ');

        System.out.println(itemLongDesc);
    }

    private static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
                System.out.print("  ");
            }
            System.out.println();
        }
    }

}
