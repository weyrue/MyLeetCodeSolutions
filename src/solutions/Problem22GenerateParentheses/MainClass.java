package solutions.Problem22GenerateParentheses;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.Future;

public class MainClass {
    public static String stringListToString(List<String> stringList) {
        StringBuilder sb = new StringBuilder("[");
        for (String item : stringList) {
            sb.append(item);
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) {
//        String line = "3";
//        int n = Integer.parseInt(line);
//
//        List<String> ret = new Solution().generateParenthesis(n);
//
//        String out = stringListToString(ret);
//
//        System.out.print(out);

        try {
            Path file = Paths.get("C:\\Users\\Yi\\Desktop\\" + "test.txt");

            AsynchronousFileChannel channel = AsynchronousFileChannel.open(file);

            ByteBuffer buffer = ByteBuffer.allocate(100_000);
            Future<Integer> result = channel.read(buffer, 0);

            channel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    System.out.println(attachment.toString());
                    System.out.println("Bytes read [" + result + "]");
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    System.err.println(exc);
                }
            });

//            while (!result.isDone()) {
//                System.out.print("干点别的事情");
//
//            }
//
//            Integer bytesRead = result.get();
//
//            System.out.print("Bytes read [" + bytesRead + "]");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
