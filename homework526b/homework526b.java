import java.io.*;
import java.util.*;
public class homework526b {
    public static void writeFile(String file, String[] poem) {
        try (RandomAccessFile exa = new RandomAccessFile(file, "rw")) {
            for (int i = 0; i < poem.length; i++) {
                String line = poem[i];
                byte[] bytes = line.getBytes("UTF-8");
                exa.write(bytes);
                exa.writeBytes("\r\n"); 
            }
            System.out.println("写入成功");
        } catch (IOException e){}
    }
    public static void Fang(String file) {
        String[] lines = new String[20]; 
        int count = 0;
        try (RandomAccessFile exa = new RandomAccessFile(file, "r")){
            long len = exa.length();
            byte[] content = new byte[(int) len];
            exa.seek(0);
            exa.readFully(content);
            String fullText = new String(content, "UTF-8");
            String[] allLines = fullText.split("\\r?\\n");
            for (int i = 0; i < allLines.length; i++) {
                String l = allLines[i];
                if (!l.isEmpty()) {
                    lines[count] = l;
                    count++; 
                }
            }
        } catch (IOException e){}
        System.out.println("—————输出 ");
        for (int i = count - 1; i >= 0; i--) {
            System.out.println(lines[i]);
        }
    }
    public static void main(String args[]) {
        String file = "huiwen.txt";
        String[] poem = {
            "开篷一棹远溪流",
            "走上烟花踏径游",
            "来客仙亭闲伴鹤",
            "泛舟渔浦满飞鸥",
            "台映碧泉寒井冷",
            "月明孤寺古林幽",
            "回望四山观落日",
            "偎林傍水绿悠悠"
        };
        writeFile(file, poem);
        Fang(file);
    }
}