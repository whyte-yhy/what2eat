package helper.utils;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LoadRealizerUtil {

    public static Map tree;
    public static BloomFilter filter;

    // map嵌套map
    public static void convert2tree(LinkedList<String> rules){
        tree = new HashMap(rules.size());
        Map curMap;
        Map<String,String> newWordMap;
        String key;
        filter = new BloomFilter();

        for (String rule : rules){
            // HashMap对象在内存中占用的是同一个地址，所以此nowMap对象的变化，tree对象也会跟着改变
            curMap = tree;
            // 遍历一行的每个词，空格分隔
            String[] atomicWord = rule.split(" ");
            // 排序
            Arrays.sort(atomicWord,0,atomicWord.length-1);
            //System.out.println(Arrays.toString(atomicWord));
            for (int i=0;i<atomicWord.length;i++){
                key = atomicWord[i];
                Object wordMap = curMap.get(key);
                // 存在则直接操作得到的map
                if (wordMap != null){
                    curMap = (Map) wordMap;
                }
                // 不存在则新建一个，得到的是<"日",<"isEnd",0>>，然后将当前操作的map更改为新建的这个map
                else {
                    newWordMap = new HashMap<>();
                    newWordMap.put("isEnd","0");
                    curMap.put(key,newWordMap);
                    curMap = newWordMap;  // 所以第一次之后的curMap都是前一个的value
                    // 加入bloom过滤器
                    filter.add(key);
                }
                // 计算结尾
                if (i==atomicWord.length-2){
                    curMap.put("isEnd","1");
                }
            }
        }
        //System.out.println(tree);
    }

}
